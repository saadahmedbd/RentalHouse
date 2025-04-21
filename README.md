# RentalHouse
This is my personal project.Try to follow best practice in this project. 

What tech stack I use in my project. I use spring boot as a backend. Postgres is a database. 

**Rental Request Rest api**
______

We create the first rental request model layer .This model layer have entity annotation. This entity annotation rental request class hibernate convert to the database.
@ID is the primary key, @GeneratedValue auto generate id. @ManyToOne many rentalRequest connect to one house and user.

**DTO(data transfer object)** →DTO help us data pass from frontend to backend and backend to frontend.

RentalRequestDTO → This help, client (frontend/postman) send to data and take response.

**Why we use a long type instead of a house and user type**
--
1. **Tight Coupling এড়াতে**

* DTO (Data Transfer Object) হচ্ছে শুধুমাত্র ডাটা পাঠানোর জন্য ইউজ করা হয়।

* যদি তুমি পুরো House বা User ক্লাস DTO-তে রাখো, তাহলে তোমার ইন্টার্নাল সিস্টেম এক্সপোজড হয়ে যায় — মানে API আর entity একসাথে tightly linked হয়ে যায়। এটা future maintenance-এ ঝামেলা করে।

2. **Payload ছোট রাখতে**

   User বা House টাইপ দিলে অনেক nested ফিল্ড চলে আসে (যেমন user.houseList, house.userList)।

    এতে JSON body অনেক বড় হয়, যেটা unnecessary।

    ID (Long) দিয়ে দিলে এটা হয় খুবই lightweight ও efficient।
3. **Lazy Loading / Recursion সমস্যা থেকে বাঁচতে**

   JPA (Hibernate) lazy loading করে। ফলে যদি entity কে DTO-তে সরাসরি রাখো, তাহলে LazyInitializationException বা infinite recursion এর মতো সমস্যা হয়।

    এক entity অন্য entity কে ধরে রাখে — এইভাবে একসময় stack overflow হয়।
4.  **Securit**y

    ক্লায়েন্ট যদি সম্পূর্ণ User পাঠাতে পারে, তাহলে সে role বা password পরিবর্তন করে পাঠাতে পারবে — এটা huge security risk।

    তুমি শুধু ID চাও, আর entity database থেকে নিজেই খুঁজে নাও — এতে control তোমার হাতে থাকে।


5. **Responsibility আলাদা থাকে**    

   DTO-এর কাজ শুধু ID পাঠানো:

    "আমি house id 3 ভাড়া নিতে চাই, আমি user id 6"

    Service এর কাজ হলো ID দিয়ে DB থেকে আসল entity খুঁজে আনা, validate করা এবং logic apply করা।

**What is DTOMapper**
---
A DTOMapper is a MapStruct interface that automatically converts:

* 🔄 Entity ↔ DTO
* 🧩 Entity: Your full database model (e.g., User, House, RentalRequest)
* 🧾 DTO: Lightweight object used for API requests/responses (e.g., UserDTO, RentalRequestDTO)

**What is MapStruct**
MapStruct is a Java annotation processor that automatically generates the code for mapping between objects — no manual boilerplate code.

It reads your interface and builds an implementation class during compile time.

Mapstruct code DTOMapper

**Step 01** **Define Mapper Interface**

`@Mapper(componentModel = "spring")
public interface UserMapper {
UserDTO toDTO(User user); // (Entity -> DTO)
User toEntity(UserDTO userDTO); // (DTO -> Entity)
}`

Step 2: MapStruct Generates This Behind The Scenes

```@Component
public class UserMapperImpl implements UserMapper {
@Override
public UserDTO toDTO(User user) {
if (user == null) return null;
UserDTO dto = new UserDTO();
dto.setId(user.getId());
dto.setName(user.getName());
dto.setEmail(user.getEmail());
return dto;
}``

    @Override
    public User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }
}`
You don’t write this manually, MapStruct does it ✨automatically✨ during build time.

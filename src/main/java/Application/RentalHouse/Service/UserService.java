package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.UpdateDTO.UpdateUserDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTO.UserRegistationDTO;

import java.util.List;


public interface UserService {

    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getUser();
    List<UserDTO> getUserByID(Long id);
    void deleteUser (Long id);
    UserDTO updateUser (Long id, UpdateUserDTO updateUserDTO);

    //for email verification
    void registerUser(UserRegistationDTO userRegistationDTO);
    void verifyEmail(String token);




    // we follow best practice that why we can't write business logic in service layer
    // we write business logic in service implementation layer

//    @Autowired
//    private UsersRepo usersRepo;
//
//
//    //get user
//    public List<User> getAllUsers(){
//        return usersRepo.findAll();
//    }
//    //get user by id
//    public User getUserById(Long id){
//        return usersRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found id "+id));
//    }
//    //create user service
//    public User createUsers(User user){
//        return usersRepo.save(user);
//    }
//    //delete data
//    public void deleteUserById(long id){
//        usersRepo.deleteById(id);
//    }
//    //update user by id
//    public User updateUserById(long id, User user){
//        User existingUser = usersRepo.findById(id).
//                orElseThrow(()-> new ResourceNotFoundException("not found id "+id)); ;
//
//            existingUser.setName(user.getName());
//            existingUser.setEmail(user.getEmail());
//            existingUser.setPassword(user.getPassword());
//            existingUser.setPhone(user.getPhone());
//            existingUser.setRole(user.getRole());
//            return usersRepo.save(existingUser);

//    }
}

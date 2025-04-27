package Application.RentalHouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity

@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
})
//lombok annotation

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //use in auto increment DB best for psql, mySQl
    private long id;

    @Column(nullable = false) //the name will not be empty
    private String name;

    @Column(nullable = false, unique = true) //email and phone will be unique
    private String email;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING) // role admin, rental, owner
    private Role role;
    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Date created_at;  //when user create account automatic set current time

    //relationship
    @OneToMany(mappedBy = "owner") // The owner can add many houses
    @JsonIgnore  // This stops serialization and breaks the cycle //avoid infinite data loops

    private List<House> houses;
    @OneToMany(mappedBy = "rental") // the rental can request many request
    private List<RentalRequest> rentalRequests;

    @OneToMany(mappedBy = "user") // the user can review much review
    private List<Review> reviews;

    //for email verification
    //step 01: add verified field
    @Column(nullable = false)
    private boolean verified =false;

    //getter and setter


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public List<RentalRequest> getRentalRequests() {
        return rentalRequests;
    }

    public void setRentalRequests(List<RentalRequest> rentalRequests) {
        this.rentalRequests = rentalRequests;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}

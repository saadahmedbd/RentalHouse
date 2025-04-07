package Application.RentalHouse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
})
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
    private String password;
    @Enumerated(EnumType.STRING) // role admin, rental, owner
    private Role role;
    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Date created_at;  //when user create account automatic set current time

    //relationship
    @OneToMany(mappedBy = "owner") // The owner can add many houses
    private List<House> houses;
    @OneToMany(mappedBy = "rental") // the rental can request many request
    private List<RentalRequest> rentalRequests;

    @OneToMany(mappedBy = "user") // the user can review much review
    private List<Review> reviews;


}

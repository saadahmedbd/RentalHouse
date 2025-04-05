package Application.RentalHouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class users {
    @Id
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private role Role;

    private Date created_at;
}

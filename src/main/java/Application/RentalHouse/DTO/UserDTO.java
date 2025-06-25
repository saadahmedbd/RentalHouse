package Application.RentalHouse.DTO;

import Application.RentalHouse.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;

//  Create a custom DTO (Data Transfer Object)
// that only includes the fields you need.
// This gives you full control over your API response format.
public class UserDTO {
    private long id;

    @NotBlank(message = "Name is required")
    private  String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email required")
    private String email;
    @Pattern(regexp = "^\\d{11}$", message = "Phone number must be exactly 11 digits")
    @Size(min = 11, max = 11, message = "Phone number must be exactly 11 digits")
    private String phone;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    private Role role;
    private Date created_at;

    //constructor


    public UserDTO() {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password; // can't add password bcz you do not want to share password
        this.role = role;
        this.created_at = created_at;
    }

    public UserDTO(long id, String name, String email, String phone, String password, Role role, Date created_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.created_at = created_at;
    }
    // getter setter


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
}

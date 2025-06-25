package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.model.User;
import org.springframework.stereotype.Component;

@Component
public class AuthUserDTOMapper {
    public User toEntity(UserDTO userDTO){
        User user=new User();
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        return user;
    }
}

package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private UsersRepo usersRepo;
    public UserDTO toDTO(User user){
        UserDTO dto =new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }

}

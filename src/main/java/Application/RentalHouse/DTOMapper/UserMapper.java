package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")//@Mapper → this is MapStruct mapper interface,
                                //componentModel =spring it's a use for spring ben
public interface UserMapper {
    UserDTO toDTO(User user); // Entity -> DTO
    User toEntity(UserDTO userDTO); //DTO -> entity


}

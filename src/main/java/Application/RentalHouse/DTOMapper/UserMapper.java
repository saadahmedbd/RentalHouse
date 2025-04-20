package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.UpdateUserDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")//@Mapper → this is MapStruct mapper interface,
                                //componentModel =spring it's a use for spring ben
public interface UserMapper {
    UserDTO toDTO(User user); // Entity -> DTO
    User toEntity(UserDTO userDTO); //DTO -> entity


    // ✅ Update existing user from DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void  UpdateUserFromDTO (UpdateUserDTO userDTO, @MappingTarget User user);
    //✅ This tells MapStruct to ignore null values (so partial updates work too).
}

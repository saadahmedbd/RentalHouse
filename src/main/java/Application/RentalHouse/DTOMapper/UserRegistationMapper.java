package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.UserRegistationDTO;
import Application.RentalHouse.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegistationMapper {
    User toEntity(UserRegistationDTO dto);

}

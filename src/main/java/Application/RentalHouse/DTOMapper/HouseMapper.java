package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateHouseDTO;
import Application.RentalHouse.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

//Clean separation for data conversion logic.
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HouseMapper {
    HouseDTO toDTO(House house); // entity -> dto
    House toEntity(HouseDTO houseDTO); //DTO -> entity

    void updateHouseFromDTO (UpdateHouseDTO houseDTO, @MappingTarget House house);

    }



package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTO.UpdateHouseDTO;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Clean separation for data conversion logic.
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HouseMapper {
    HouseDTO toDTO(House house); // entity -> dto
    House toEntity(HouseDTO houseDTO); //DTO -> entity

    void updateHouseFromDTO (UpdateHouseDTO houseDTO, @MappingTarget House house);

    }



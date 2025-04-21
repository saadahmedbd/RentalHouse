package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.RentalRequestDTO;
import Application.RentalHouse.model.RentalRequest;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel="Spring")
public interface RentalRequestDTOMapper {
    // Entity to DTO
    @Mapping(source = "house.house_id", target = "houseId")
    @Mapping(source = "rental.id", target = "rentalId")
    RentalRequestDTO toDTO(RentalRequest rentalRequest); // Entity -> DTO


    // DTO → Entity mapping-এ house ও rental manually handle করবো, তাই ignore করি
    @Mapping(target = "house", ignore = true)
    @Mapping(target = "rental", ignore = true)
    RentalRequest toEntity(RentalRequestDTO rentalRequestDTO); // DTO -> Entity
}

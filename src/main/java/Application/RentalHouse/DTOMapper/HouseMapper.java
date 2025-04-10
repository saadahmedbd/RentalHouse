package Application.RentalHouse.DTOMapper;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Clean separation for data conversion logic.
@Component
public class HouseMapper {
    @Autowired
    private HouseRepo houseRepo;
    public HouseDTO toDTO(House house){
        HouseDTO dto =new HouseDTO();
        dto.setHouse_id(house.getHouse_id());
        dto.setTitle(house.getTitle());
        dto.setDescription(house.getDescription());
        dto.setAddress(house.getAddress());
        dto.setCity(house.getCity());
        dto.setRent_price(house.getRent_price());
        dto.setSize(house.getSize());
        dto.setBedrooms(house.getBedrooms());
        dto.setBathrooms(house.getBathrooms());
        dto.setAvailable(house.isAvailable());
        dto.setCreated_at(house.getCreated_at());
        dto.setOwner(house.getOwner());
        return dto;
    }
    public House toEntity (HouseDTO dto){
        House house =new House();
        house.setHouse_id(dto.getHouse_id());
        house.setTitle(dto.getTitle());
        house.setDescription(dto.getDescription());
        house.setAddress(dto.getAddress());
        house.setCity(dto.getCity());
        house.setRent_price(dto.getRent_price());
        house.setSize(dto.getSize());
        house.setBedrooms(dto.getBedrooms());
        house.setBathrooms(dto.getBathrooms());
        house.setAvailable(dto.isAvailable());
        house.setCreated_at(dto.getCreated_at());
        house.setOwner(dto.getOwner());
        return house;
    }

}

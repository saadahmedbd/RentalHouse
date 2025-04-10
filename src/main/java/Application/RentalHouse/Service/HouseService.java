package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.model.House;

//separate to business logic to it's use for controller
public interface HouseService {
    HouseDTO createHouse(HouseDTO houseDTO);
    HouseDTO getHouse(long house_id);

}

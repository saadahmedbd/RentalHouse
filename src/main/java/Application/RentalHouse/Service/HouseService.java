package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateHouseDTO;

import java.util.List;

//separate to business logic to it's use for controller
public interface HouseService {
    HouseDTO createHouse(HouseDTO houseDTO);
    List<HouseDTO> getHouseById (Long id);
    List<HouseDTO> getHouse();
    void deleteHouse(Long id);

    HouseDTO updateHouse(Long id, UpdateHouseDTO updateHouseDTO);

}

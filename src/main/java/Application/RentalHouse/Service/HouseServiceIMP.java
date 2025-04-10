package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTOMapper.HouseMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//divide serviceImp for scaling, testing, and abstraction.
@Service
public class HouseServiceIMP implements HouseService {
    @Autowired
    private HouseRepo houseRepo;
    @Autowired
    private HouseMapper houseMapper;



    @Override
    public HouseDTO createHouse(HouseDTO dto) {
        House house =houseMapper.toEntity(dto);
        return houseMapper.toDTO(houseRepo.save(house));
    }

    @Override
    public HouseDTO getHouse(long house_id) {
        House house =houseRepo.findById(house_id).orElseThrow(()
                -> new ResourceNotFoundException("user not found"));
        return houseMapper.toDTO(house);
    }




















    //    //get houses
//    public List<House> getAllHouse(){
//        return houseRepo.findAll();
//    }
}

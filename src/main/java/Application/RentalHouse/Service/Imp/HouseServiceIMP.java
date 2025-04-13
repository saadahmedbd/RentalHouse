package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTOMapper.HouseMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.Service.HouseService;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<HouseDTO> getHouseById(Long id) {
        return houseRepo.findById(id).stream().
                map(houseMapper::toDTO).
                collect(Collectors.toList());
    }

    @Override
    public List<HouseDTO> getHouse() {
        return houseRepo.findAll().stream()
                .map(houseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHouse(Long id) {
        houseRepo.deleteById(id);
    }


    //    //get houses
//    public List<House> getAllHouse(){
//        return houseRepo.findAll();
//    }
}

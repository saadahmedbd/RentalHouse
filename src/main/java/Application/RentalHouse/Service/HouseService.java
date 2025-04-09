package Application.RentalHouse.Service;

import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepo houseRepo;

    //get houses
    public List<House> getAllHouse(){
        return houseRepo.findAll();
    }
}

package Application.RentalHouse.Controller;

import Application.RentalHouse.Service.HouseService;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseCon {
    @Autowired
    private HouseService houseService;

    //get houses
    @GetMapping
    public List<House> getAllHouse(){
        return houseService.getAllHouse();
    }
}

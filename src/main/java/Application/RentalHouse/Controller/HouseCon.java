package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.Service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseCon {
    private final HouseService houseService;

    public HouseCon(HouseService houseService) {
        this.houseService = houseService;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<HouseDTO> getHouse(@PathVariable long id){
//        return ResponseEntity.ok(houseService.getHouseById(id));
//    }
    @GetMapping("/{id}")
    public List<HouseDTO> getHouseById(@PathVariable long id){
        return houseService.getHouseById(id);
    }
    @GetMapping
    public  List<HouseDTO> getHouses(){
        return houseService.getHouse();
    }
    @PostMapping
    public ResponseEntity<HouseDTO> createHouse(@RequestBody HouseDTO houseDTO){
            return  ResponseEntity.status(HttpStatus.CREATED).body(houseService.createHouse(houseDTO));
    }
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable long id){
        houseService.deleteHouse(id);
    }






    //get houses
//    @GetMapping
//    public List<House> getAllHouse(){
//        return houseService.getAllHouse();
//    }

}

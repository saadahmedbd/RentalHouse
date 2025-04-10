package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.Service.HouseService;
import Application.RentalHouse.Service.HouseServiceIMP;
import Application.RentalHouse.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/house")
public class HouseCon {
    @Autowired
    private HouseService houseService;
    @GetMapping("/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable long id){
        return ResponseEntity.ok(houseService.getHouse(id));
    }
    @PostMapping
    public ResponseEntity<HouseDTO> createHouse(@RequestBody HouseDTO dto){
            return  ResponseEntity.status(HttpStatus.CREATED).body(houseService.createHouse(dto));
    }






    //get houses
//    @GetMapping
//    public List<House> getAllHouse(){
//        return houseService.getAllHouse();
//    }

}

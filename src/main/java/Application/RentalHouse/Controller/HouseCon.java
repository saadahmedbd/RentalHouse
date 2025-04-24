package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.HouseDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateHouseDTO;
import Application.RentalHouse.DTOMapper.HouseMapper;
import Application.RentalHouse.DTOMapper.UserMapper;
import Application.RentalHouse.Service.HouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseCon {
    private final HouseService houseService;
    private final HouseMapper houseMapper;

    public HouseCon(HouseService houseService, UserMapper userMapper, HouseMapper houseMapper) {
        this.houseService = houseService;
        this.houseMapper = houseMapper;
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
    public ResponseEntity<HouseDTO> createHouse(@Valid @RequestBody HouseDTO houseDTO){
            return  ResponseEntity.status(HttpStatus.CREATED).body(houseService.createHouse(houseDTO));
    }
    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable long id){
        houseService.deleteHouse(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HouseDTO> updateHouse (@PathVariable long id, @RequestBody UpdateHouseDTO updateHouseDTO){
       // House updateHouse = houseService.updateHouse(id, updateHouseDTO);
        return ResponseEntity.ok(houseService.updateHouse(id,updateHouseDTO));
    }






    //get houses
//    @GetMapping
//    public List<House> getAllHouse(){
//        return houseService.getAllHouse();
//    }

}

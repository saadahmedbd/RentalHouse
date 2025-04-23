package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.RentalRequestDTO;
import Application.RentalHouse.Service.RentalRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentReq")
public class RentalReqCon {
    private final RentalRequestService rentalRequestService;

    public RentalReqCon(RentalRequestService rentalRequestService) {
        this.rentalRequestService = rentalRequestService;
    }
    @PostMapping
    public ResponseEntity<RentalRequestDTO> createRentalReq(@RequestBody RentalRequestDTO rentalRequestDTO){
//        return ResponseEntity.ok(rentalRequestService.createRentalRequest(rentalRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rentalRequestService.createRentalReq(rentalRequestDTO));
    }
    @GetMapping
    public List<RentalRequestDTO> getRentalReq(){
        return rentalRequestService.getRentalReq();
    }
    @GetMapping("/{id}")
    public List<RentalRequestDTO> getRentalReqById(@PathVariable long id){
        return rentalRequestService.getRentalReqById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteRentalreqById(@PathVariable long id){
        rentalRequestService.deleteRentalReq(id);
    }
}

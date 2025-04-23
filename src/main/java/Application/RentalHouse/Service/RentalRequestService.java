package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.RentalRequestDTO;
import Application.RentalHouse.model.RentalRequest;

import java.util.List;

public interface RentalRequestService  {
    RentalRequestDTO createRentalReq(RentalRequestDTO rentalRequestDTO);

    List<RentalRequestDTO> getRentalReq();
    List<RentalRequestDTO> getRentalReqById(long id);

    void deleteRentalReq (long id);

}

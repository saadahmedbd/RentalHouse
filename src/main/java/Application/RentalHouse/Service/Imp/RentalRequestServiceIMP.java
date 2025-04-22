package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.RentalRequestDTO;
import Application.RentalHouse.DTOMapper.RentalRequestDTOMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.Repository.RentalRepo;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.RentalRequestService;
import Application.RentalHouse.model.House;
import Application.RentalHouse.model.RentalRequest;
import Application.RentalHouse.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalRequestServiceIMP implements RentalRequestService {
    private final RentalRequestDTOMapper rentalRequestDTOMapper;
    private final RentalRepo rentalRepo;
    private final HouseRepo houseRepo;
    private  final UsersRepo rental;

    public RentalRequestServiceIMP(RentalRequestDTOMapper rentalRequestDTOMapper, RentalRepo rentalRepo, HouseRepo houseRepo, UsersRepo rental) {
        this.rentalRequestDTOMapper = rentalRequestDTOMapper;
        this.rentalRepo = rentalRepo;
        this.houseRepo = houseRepo;
        this.rental = rental;
    }

    public RentalRequestDTO createRentalReq(RentalRequestDTO rentalRequestDTO){
//        RentalRequest rentalRequest =rentalRequestDTOMapper.toEntity(rentalRequestDTO); // dto to entity
//        RentalRequest saved =rentalRepo.save(rentalRequest); //saved in db
//        return rentalRequestDTOMapper.toDTO(saved); //entity to dto

        //if you set relation data long type than your relationship data set format like below
        House house = houseRepo.findById(rentalRequestDTO.getHouseId()).
                orElseThrow(()-> new ResourceNotFoundException("house id"+ rentalRequestDTO.getHouseId()));

        User user =rental.findById(rentalRequestDTO.getRentalId())
                .orElseThrow(()-> new ResourceNotFoundException("rental id"+ rentalRequestDTO.getRentalId()));

        RentalRequest rentalRequest =new RentalRequest();


        rentalRequest.setHouse(house);
        rentalRequest.setRental(user);
        rentalRequest.setStatus(rentalRequestDTO.getStatus());

       rentalRequest.setStarted(rentalRequestDTO.getStarted());
       rentalRequest.setEndDate(rentalRequestDTO.getEndDate());

        RentalRequest saved =rentalRepo.save(rentalRequest);
        return rentalRequestDTOMapper.toDTO(saved); //entity to dto
    }

    @Override
    public List<RentalRequestDTO> getRentalReq() {
        return rentalRepo.findAll().stream().map(rentalRequestDTOMapper::toDTO).collect(Collectors.toList());
    }
}

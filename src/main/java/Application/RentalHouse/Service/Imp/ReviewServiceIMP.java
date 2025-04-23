package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.ReviewDTO;
import Application.RentalHouse.DTOMapper.ReviewMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.HouseRepo;
import Application.RentalHouse.Repository.ReviewRepo;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.ReviewService;
import Application.RentalHouse.model.House;
import Application.RentalHouse.model.Review;
import Application.RentalHouse.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceIMP implements ReviewService {
    private final ReviewMapper reviewMapper;
    private final HouseRepo houseRepo;
    private final UsersRepo usersRepo;
    private final ReviewRepo reviewRepo;


    public ReviewServiceIMP(ReviewMapper reviewMapper, HouseRepo houseRepo, UsersRepo usersRepo, ReviewRepo reviewRepo) {
        this.reviewMapper = reviewMapper;

        this.houseRepo = houseRepo;
        this.usersRepo = usersRepo;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        House house = houseRepo.findById(reviewDTO.getHouseId()).orElseThrow(()->
                new ResourceNotFoundException("house id"+reviewDTO.getHouseId()+" not found"));
        User user =usersRepo.findById(reviewDTO.getUserId()).orElseThrow(()->
                new ResourceNotFoundException("user id"+reviewDTO.getUserId()+" not found"));

        Review review =new Review();
        review.setHouse(house);
        review.setUser(user);
        review.setComment(reviewDTO.getComment());
        review.setRating(reviewDTO.getRating());
        review.setUrl(reviewDTO.getUrl());

        Review saved =reviewRepo.save(review); //save in db
        return  reviewMapper.toDTO(saved); //entity to dto
    }

    @Override
    public List<ReviewDTO> getReview() {
        return reviewRepo.findAll().stream().map(reviewMapper::toDTO).collect(Collectors.toList());
    }
}

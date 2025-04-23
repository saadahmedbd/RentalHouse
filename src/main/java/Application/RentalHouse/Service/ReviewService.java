package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getReview();
}

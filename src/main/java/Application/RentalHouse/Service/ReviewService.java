package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.ReviewDTO;
import Application.RentalHouse.DTO.UpdateDTO.UpdateReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getReview();
    List<ReviewDTO> getReviewById(long id);
    void deleteById(long id);

    ReviewDTO updateReviewById (long id, UpdateReviewDTO updateReviewDTO);
}

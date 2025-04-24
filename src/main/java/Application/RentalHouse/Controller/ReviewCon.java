package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.ReviewDTO;
import Application.RentalHouse.Service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewCon {

    private final ReviewService reviewService;

    public ReviewCon(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public ResponseEntity<ReviewDTO> createReview (@RequestBody ReviewDTO reviewDTO){
        return ResponseEntity.ok().body(reviewService.createReview(reviewDTO));
    }
    @GetMapping
    public List<ReviewDTO> getReview(){
        return reviewService.getReview();
    }
    @GetMapping("/{id}")
    public List<ReviewDTO> getReviewById(@PathVariable long id){
        return reviewService.getReviewById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable long id){
        reviewService.deleteById(id);
    }
}

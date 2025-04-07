package Application.RentalHouse.Repository;

import Application.RentalHouse.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review,Long> {
}

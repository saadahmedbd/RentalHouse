package Application.RentalHouse.Repository;

import Application.RentalHouse.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
}

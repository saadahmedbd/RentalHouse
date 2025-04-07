package Application.RentalHouse.Repository;

import Application.RentalHouse.model.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<RentalRequest,Long> {
}

package Application.RentalHouse.Repository;

import Application.RentalHouse.model.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepo extends JpaRepository<RentalRequest,Long> {
}

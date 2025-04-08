package Application.RentalHouse.Repository;

import Application.RentalHouse.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends JpaRepository<House,Long> {
}

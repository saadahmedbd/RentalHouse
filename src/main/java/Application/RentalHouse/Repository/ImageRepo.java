package Application.RentalHouse.Repository;

import Application.RentalHouse.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {
}

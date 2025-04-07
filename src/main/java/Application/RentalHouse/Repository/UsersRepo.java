package Application.RentalHouse.Repository;

import Application.RentalHouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<User,Long> {

}

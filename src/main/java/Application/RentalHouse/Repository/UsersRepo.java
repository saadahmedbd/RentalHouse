package Application.RentalHouse.Repository;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Optional<User> findByEmail(String username);
}

package Application.RentalHouse.Repository;

import Application.RentalHouse.model.User;
import Application.RentalHouse.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//step 04
@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token); //Retrieves the token using the string
                                                            // value of the token sent to the user's email.
    Optional<VerificationToken> findByUser(User user); //Query by user (for checking if a token exists)
}

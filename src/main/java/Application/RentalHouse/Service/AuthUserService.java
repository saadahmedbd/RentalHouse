package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthUserService {
    void RegisterUser (UserDTO userDTO);
}

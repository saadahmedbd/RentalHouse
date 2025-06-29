package Application.RentalHouse.Service;

import Application.RentalHouse.DTO.LoginRequestDTO;
import Application.RentalHouse.DTO.LoginResponceDTO;
import Application.RentalHouse.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthUserService {
    void RegisterUser (UserDTO userDTO);
    LoginResponceDTO login(LoginRequestDTO loginDTO);
}

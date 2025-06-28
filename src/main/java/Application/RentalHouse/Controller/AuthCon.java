package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.AuthUserService;
import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthCon {

    private final AuthUserService authUserService;


    public AuthCon(AuthUserService authUserService) {
        this.authUserService = authUserService;


    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO user) {
        try {
            authUserService.RegisterUser(user);
            return ResponseEntity.ok().body("registration successful");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(java.util.Map.of("message", e.getMessage()));
        }
    }
}



package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.LoginRequestDTO;
import Application.RentalHouse.DTO.LoginResponceDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.Service.AuthUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginDTO){
        try{
            LoginResponceDTO loginResponceDTO=authUserService.login(loginDTO);
            return ResponseEntity.ok(loginResponceDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(java.util.Map.of("message",e.getMessage()));
        }
    }
}



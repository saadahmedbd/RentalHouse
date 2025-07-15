package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.LoginRequestDTO;
import Application.RentalHouse.DTO.LoginResponceDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.Service.AuthUserService;
import Application.RentalHouse.Service.Imp.JwtService;
import Application.RentalHouse.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthCon {

    private final AuthUserService authUserService;
    private final JwtService jwtService;
    


    public AuthCon(AuthUserService authUserService, JwtService jwtService) {
        this.authUserService = authUserService;

        this.jwtService = jwtService;
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
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO loginDTO){
//        try{
//            LoginResponceDTO loginResponceDTO=authUserService.login(loginDTO);
//            return ResponseEntity.ok(loginResponceDTO);
//        }catch (IllegalArgumentException e){
//            return ResponseEntity.badRequest().body(java.util.Map.of("message",e.getMessage()));
//        }
//    }
    @PostMapping("/Jwtlogin")
    public String login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponceDTO loginResponceDTO=authUserService.loginJwt(loginRequestDTO);
//        return ResponseEntity.ok(loginResponceDTO);
        return jwtService.generateToken(loginRequestDTO.getEmail());
    }

}



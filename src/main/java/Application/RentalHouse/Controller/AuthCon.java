package Application.RentalHouse.Controller;

import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthCon {
        private final UsersRepo usersRepo;
        private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public AuthCon(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if(usersRepo.findByEmail(user.getEmail()).isPresent()){
            return  ResponseEntity.badRequest().body("Email/user already found");
        } if (usersRepo.findByPhone(user.getPhone()).isPresent()) {
            return ResponseEntity.badRequest().body("phone number already exist");

        }
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);
        return ResponseEntity.ok("Register succesful");
    }
}

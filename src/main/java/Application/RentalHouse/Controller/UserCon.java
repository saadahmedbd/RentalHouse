package Application.RentalHouse.Controller;

import Application.RentalHouse.DTO.UpdateDTO.UpdateUserDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTO.UserRegistationDTO;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserCon {
    public  final UserService userService;
    public final UsersRepo usersRepo;
    public final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public UserCon(UserService userService, UsersRepo usersRepo) {
        this.userService = userService;
        this.usersRepo = usersRepo;
    }



    @GetMapping
    public List<UserDTO> getAllUser(){
        return userService.getUser();
    }
    @GetMapping("/{id}")
    public List<UserDTO> getUserBYID(@PathVariable long id){
        return userService.getUserByID(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUserBYId(@PathVariable long id){
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UpdateUserDTO updateUserDTO){
       // UserDTO updateUser =userService.updateUser(id,updateUserDTO);
        return ResponseEntity.ok(userService.updateUser(id,updateUserDTO));
    }















    // this code for without MapStruct DTO.

//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public List<User> getAllUsers(){
//        return userService.getAllUsers();
//    }
//    // get user by id
////    @GetMapping("/{id}")
////    public ResponseEntity<User> getUserById(@PathVariable long id){
////        return userService.getUserById(id)
////                .map(ResponseEntity::ok)
////                .orElse(ResponseEntity.notFound().build());
////    }
//    //or use
//    //different between responseEntity and optional
//    //if user by id do not have in a database response entity give you not found
//    // and optional give you null value
//
//
//    @GetMapping("/{id}")
//    public User getuserId(@PathVariable long id){
//        return userService.getUserById(id);
//    }
//
//    // create user in db
//    @PostMapping
//    public User createUser(@RequestBody User user){
//        return userService.createUsers(user);
//    }
//    //update user
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable long id, @RequestBody User user){
//        return userService.updateUserById(id,user);
//    }
//
//    //delete user
//    //if user have relationship between another class, then this user you can't delete
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUserId(@PathVariable long id){
//        userService.deleteUserById(id);
//        return ResponseEntity.ok().build();
//    }
//
////    @DeleteMapping("/{id}")
////    public void deleteUserById(@PathVariable long id){
////        userService.deleteUserById(id);
////    }

}

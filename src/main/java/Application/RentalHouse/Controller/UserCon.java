package Application.RentalHouse.Controller;

import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserCon {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    // get user by id
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable long id){
//        return userService.getUserById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
    //or use
    //different between responseEntity and optional
    //if user by id do not have in a database response entity give you not found
    // and optional give you null value


    @GetMapping("/{id}")
    public User getuserId(@PathVariable long id){
        return userService.getUserById(id);
    }

    // create user in db
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUsers(user);
    }
    //update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }

    //delete user
    //if user have relationship between another class, then this user you can't delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserId(@PathVariable long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable long id){
//        userService.deleteUserById(id);
//    }

}

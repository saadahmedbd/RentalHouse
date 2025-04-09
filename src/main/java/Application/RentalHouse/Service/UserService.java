package Application.RentalHouse.Service;

import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepo usersRepo;


    //get user
    public List<User> getAllUsers(){
        return usersRepo.findAll();
    }
    //get user by id
    public User getUserById(Long id){
        return usersRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found id "+id));
    }
    //create user service
    public User createUsers(User user){
        return usersRepo.save(user);
    }
    //delete data
    public void deleteUserById(long id){
        usersRepo.deleteById(id);
    }
    //update user by id
    public User updateUserById(long id, User user){
        User existingUser = usersRepo.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("not found id "+id)); ;

            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhone(user.getPhone());
            existingUser.setRole(user.getRole());
            return usersRepo.save(existingUser);

    }
}

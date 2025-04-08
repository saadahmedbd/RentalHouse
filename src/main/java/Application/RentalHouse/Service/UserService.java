package Application.RentalHouse.Service;

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

    public List<User> getAllUsers(){
        return usersRepo.findAll();
    }
    public Optional<User> getUserById(Long id){
        return usersRepo.findById(id);
    }
    //create user service
    public User createUsers(User user){
        return usersRepo.save(user);
    }
    //delete data
    public void deleteUserById(long id){
        usersRepo.deleteById(id);
    }
}

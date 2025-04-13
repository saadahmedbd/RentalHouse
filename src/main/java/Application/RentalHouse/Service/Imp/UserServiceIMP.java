package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTOMapper.UserMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMP implements UserService {
    private final UsersRepo usersRepo;

    private final UserMapper userMapper;

    public UserServiceIMP(UsersRepo usersRepo, UserMapper userMapper) {
        this.usersRepo = usersRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user =userMapper.toEntity(userDTO); //DTO -> entity
        User saved =usersRepo.save(user);       // save in DB
        return userMapper.toDTO(saved);         // entity to DTO
    }

    @Override
    public List<UserDTO> getUser() {
        return usersRepo.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUserByID(Long id) {
        return usersRepo.findById(id).stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        usersRepo.deleteById(id);
    }




}

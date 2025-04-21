package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.UpdateDTO.UpdateUserDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTOMapper.UserMapper;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
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

    @Override
    public UserDTO updateUser(Long id,UpdateUserDTO updateUserDTO) {
        User user =usersRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user"+ id+"not found"));

        userMapper.UpdateUserFromDTO(updateUserDTO,user); //copy field
        User UpdateUser =usersRepo.save(user); //save in db
        return userMapper.toDTO(user); //return update dto
    }


}

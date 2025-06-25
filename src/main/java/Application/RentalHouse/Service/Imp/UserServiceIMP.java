package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.UpdateDTO.UpdateUserDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTO.UserRegistationDTO;
import Application.RentalHouse.DTOMapper.UserMapper;
import Application.RentalHouse.Execption.EmailAlreadyExistsException;
import Application.RentalHouse.Execption.EmailNotVerifedException;
import Application.RentalHouse.Execption.ResourceNotFoundException;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Repository.VerificationTokenRepo;
import Application.RentalHouse.Service.MailService;
import Application.RentalHouse.Service.UserService;
import Application.RentalHouse.model.User;
import Application.RentalHouse.model.VerificationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceIMP implements UserService {
    private final UsersRepo usersRepo;

    private final UserMapper userMapper;
    private final MailService mailService;
    private final VerificationTokenRepo verificationTokenRepo;

    public UserServiceIMP(UsersRepo usersRepo, UserMapper userMapper, MailService mailService, VerificationTokenRepo verificationTokenRepo) {
        this.usersRepo = usersRepo;
        this.userMapper = userMapper;
        this.mailService = mailService;
        this.verificationTokenRepo = verificationTokenRepo;
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
    //for email verification




}

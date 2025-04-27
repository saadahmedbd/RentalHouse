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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    //for email verification

    @Override
    public void registerUser(UserRegistationDTO userRegistationDTO) {
        if(usersRepo.findByEmail(userRegistationDTO.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email already exist");
        }
        User user =userMapper.toEntity(userRegistationDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(userRegistationDTO.getPassword()));
        usersRepo.save(user);

        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationToken.setExpiry_date(LocalDateTime.now().plusMinutes(15));
        verificationTokenRepo.save(verificationToken);

        mailService.sendVerificationEmail(user.getEmail(), token);
    }

    @Override
    public void verifyEmail(String token) {
        VerificationToken verificationToken=verificationTokenRepo.findByToken(token).
                orElseThrow(()-> new EmailNotVerifedException("invalid email"));
        if (verificationToken.getExpiry_date().isBefore(LocalDateTime.now())) {
            throw new EmailNotVerifedException("Token expired.");
        }

        User user = verificationToken.getUser();
        verificationTokenRepo.delete(verificationToken); // Token delete after verification
        usersRepo.save(user); // Save again to trigger any needed events

    }
    public boolean isEmailVerified(User user) {
        Optional<VerificationToken> tokenOptional = verificationTokenRepo.findByUser(user);
        return tokenOptional.isEmpty();
    }


}

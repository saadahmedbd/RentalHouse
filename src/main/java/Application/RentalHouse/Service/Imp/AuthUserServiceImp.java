package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.DTO.LoginRequestDTO;
import Application.RentalHouse.DTO.LoginResponceDTO;
import Application.RentalHouse.DTO.UserDTO;
import Application.RentalHouse.DTOMapper.AuthUserDTOMapper;
import Application.RentalHouse.DTOMapper.UserMapper;
import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.Service.AuthUserService;
import Application.RentalHouse.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserServiceImp implements AuthUserService {
    private final UsersRepo usersRepo;
    private final AuthUserDTOMapper authUserDTOMapper;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    private final AuthenticationManager authenticationManager;

    public AuthUserServiceImp(UsersRepo usersRepo, UserMapper userMapper, AuthUserDTOMapper authUserDTOMapper, AuthenticationManager authenticationManager) {
        this.usersRepo = usersRepo;
        this.authUserDTOMapper = authUserDTOMapper;

        this.authenticationManager = authenticationManager;
    }

    @Override
    public void RegisterUser(UserDTO userDTO) {
        String rawPassword=userDTO.getPassword();
        if(usersRepo.existsByEmail(userDTO.getEmail())){
            throw new IllegalArgumentException("email already exist");
        }if(usersRepo.existsByPhone(userDTO.getPhone())){
            throw  new IllegalArgumentException("phone number already exist");
        }if(rawPassword == null){
            throw new IllegalArgumentException("password not be null");
        }

            User user= authUserDTOMapper.toEntity(userDTO);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(encoder.encode(rawPassword));
        user.setRole(userDTO.getRole());
         usersRepo.save(user);
    }

    @Override
    public LoginResponceDTO login(LoginRequestDTO loginDTO) {
        User user=usersRepo.findByEmail(loginDTO.getEmail()).orElseThrow(()->
                new IllegalArgumentException("Invalid email or password"));
        if(!encoder.matches(loginDTO.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("Invalid email or password");
        }
        return new LoginResponceDTO(loginDTO.getEmail(), loginDTO.getPassword());
    }

    @Override
    public LoginResponceDTO loginJwt(LoginRequestDTO loginDTO) {
        Authentication authenticationManager1= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken( loginDTO.getEmail(), loginDTO.getPassword())
        );
        return new LoginResponceDTO("login successful",loginDTO.getEmail());
    }


}

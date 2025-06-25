package Application.RentalHouse.Service.Imp;

import Application.RentalHouse.Repository.UsersRepo;
import Application.RentalHouse.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    public final UsersRepo usersRepo;

    public UserDetailsServiceImp(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("username/email not found"));
    }
}



package Application.RentalHouse.Configuration;

import Application.RentalHouse.Service.Imp.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {


    public final UserDetailsServiceImp userDetailsService;

    public securityConfig(UserDetailsServiceImp userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/auth/**",
                                        "/api/**")
                                .permitAll()
                        .anyRequest().authenticated())




//
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .userDetailsService(userDetailsService)
                .build();
    }
//    Every time user sends login request spring built in username password authentication manager
//    checks username and password, and it will generate token that check is user valid or not.
//
//In this case, when send the request, request goes to authentication manager;
// authentication manager gives token to authentication provider. We use DAO Authentication provider.
    @Bean
    public  AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1= User.withDefaultPasswordEncoder()
//                .username("saad")
//                .password("saad123")
//                .roles("User")
//                .build();
//        UserDetails user2=User.withDefaultPasswordEncoder()
//                .username("hridoy")
//                .password("hridoy123")
//                .roles("landlord")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
}

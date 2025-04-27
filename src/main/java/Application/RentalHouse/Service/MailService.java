package Application.RentalHouse.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendVerificationEmail(String to, String token){
        String link ="http://localhost:8080/api/users/verify?token=" + token;
        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Email verification");
        message.setText("plese click the link to verify your email "+ link);
        javaMailSender.send(message);

    }
}

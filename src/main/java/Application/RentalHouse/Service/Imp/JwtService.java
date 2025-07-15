package Application.RentalHouse.Service.Imp;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service

public class JwtService {

    private String secretKey;
    public JwtService(){
        secretKey=generateSecretKey();
    }

    private String generateSecretKey(){
        try {
            KeyGenerator keyGen=KeyGenerator.getInstance("HmacSha256");
            SecretKey secretKey=keyGen.generateKey();
            System.out.println("secret key: "+secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());

        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Error generating secket key",e);
        }
    }
   public Key getKey(){
        byte [] keyByte=Decoders.BASE64.decode(generateSecretKey());
        return Keys.hmacShaKeyFor(keyByte);
   }

    public String generateToken(String email) {

        Map<String,Object> claims=new HashMap<>();


        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 3))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}

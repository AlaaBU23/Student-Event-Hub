package CS673.SpringBootStudentEventHub.tools;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static final String jwtToken = "123456cs673!@###$$";

    public static String createToken(String userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // Issuance algorithm, secret key is jwtToken
                .setClaims(claims) // Body data, to be unique, self-set
                .setIssuedAt(new Date()) // Setting the time of issuance
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));// Effective time of day
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

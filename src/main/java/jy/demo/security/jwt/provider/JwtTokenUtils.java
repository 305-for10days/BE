package jy.demo.security.jwt.provider;

import static jy.demo.security.jwt.provider.JwtTokenValue.CLAIM_EXPIRED_DATE;
import static jy.demo.security.jwt.provider.JwtTokenValue.CLAIM_USER_EMAIL;
import static jy.demo.security.jwt.provider.JwtTokenValue.CLAIM_USER_ID;
import static jy.demo.security.jwt.provider.JwtTokenValue.CLAIM_USER_NICK;
import static jy.demo.security.jwt.provider.JwtTokenValue.CLAIM_USER_PROFILE_EXIST;
import static jy.demo.security.jwt.provider.JwtTokenValue.JWT_SECRET;
import static jy.demo.security.jwt.provider.JwtTokenValue.JWT_TOKEN_VALID_MILLI_SEC;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import jy.demo.security.oauth2.CustomOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public final class JwtTokenUtils {

    public String generateJwtToken(CustomOAuth2User userInfo) {
        String token = null;
        try {
            token = JWT.create()
                .withIssuer("JY")
                .withClaim(CLAIM_USER_EMAIL, userInfo.getEmail())
                .withClaim(CLAIM_USER_ID, userInfo.getId())
                .withClaim(CLAIM_USER_NICK, userInfo.getName())
                .withClaim(CLAIM_USER_PROFILE_EXIST, userInfo.getIsProfileExist())
                .withClaim(CLAIM_EXPIRED_DATE, new Date(System.currentTimeMillis() + JWT_TOKEN_VALID_MILLI_SEC))
                .sign(generateAlgorithm());

            log.info(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return token;
    }

    private Algorithm generateAlgorithm() {
        return Algorithm.HMAC256(JWT_SECRET);
    }

}
package jy.demo.security.jwt.filter;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@Component
public class HeaderTokenExtractor {

    public final String HEADER_PREFIX = "Bearer ";

    public String extract(String header, HttpServletRequest request) {
        if (header == null || header.equals("") || header.length() < HEADER_PREFIX.length()) {
            System.out.println("error request : " + request.getRequestURI());
            throw new NoSuchElementException("올바른 JWT 정보가 아닙니다.");
        }

        return header.substring(
            HEADER_PREFIX.length(),
            header.length()
        );
    }
}

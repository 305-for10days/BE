package jy.demo.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public enum HttpResponse {
    OK(HttpStatus.OK, "OK"),

    INVALID_ID_PASSWORD(HttpStatus.BAD_REQUEST, "잘못된 아이디 혹은 패스워드 입니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다"),
    PROFILE_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자의 프로필 데이터가 존재하지 않습니다"),
    PROFILE_EXIST(HttpStatus.NOT_FOUND, "사용자의 프로필 데이터가 이미 저장되어있습니다"),
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "토큰이 존재하지 않습니다"),
    INVALID_KAKAO_OAUTH(HttpStatus.NOT_FOUND, "잘못된 카카오 사용자 데이터 입니다"),
    INVALID_GOOGLE_OAUTH(HttpStatus.NOT_FOUND, "잘못된 구글 사용자 데이터 입니다"),
    EXERCISE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 운동입니다"),
    EXERCISE_GOAL_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 운동목적입니다"),
    USER_ROUTINE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 유저 루틴입니다"),
    INVALID_TOKEN(HttpStatus.NON_AUTHORITATIVE_INFORMATION, "유효하지 않은 토큰입니다");


    private final org.springframework.http.HttpStatus httpStatus;
    private final String message;

    HttpResponse(org.springframework.http.HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ResponseEntity<String> getResponseEntity() {
        return ResponseEntity.status(httpStatus).body(message);
    }
}

package ru.netology.studenikin_authorizationservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.studenikin_authorizationservice.exception.InvalidCredentials;
import ru.netology.studenikin_authorizationservice.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icHandler(InvalidCredentials ic) {
        return new ResponseEntity<>(ic.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuHandler(UnauthorizedUser uu) {
        return new ResponseEntity<>(uu.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}

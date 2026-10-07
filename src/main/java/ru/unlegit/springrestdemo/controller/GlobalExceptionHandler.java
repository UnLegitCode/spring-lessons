package ru.unlegit.springrestdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.unlegit.springrestdemo.dto.ErrorInfo;
import ru.unlegit.springrestdemo.exception.book.BookNotFoundException;
import ru.unlegit.springrestdemo.exception.user.UserAuthenticationException;
import ru.unlegit.springrestdemo.exception.user.UserEmailAlreadyTakenException;
import ru.unlegit.springrestdemo.exception.user.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UserNotFoundException.class, BookNotFoundException.class})
    public ErrorInfo handleNotFound(Exception exception) {
        return new ErrorInfo(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserEmailAlreadyTakenException.class)
    public ErrorInfo handleConflict(Exception exception) {
        return new ErrorInfo(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UserAuthenticationException.class)
    public ErrorInfo handleUnauthorized(Exception exception) {
        return new ErrorInfo(exception.getMessage());
    }
}
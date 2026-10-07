package ru.unlegit.springrestdemo.exception.user;

public class UserAuthenticationException extends RuntimeException {

    public UserAuthenticationException() {
        super("Неверный пароль");
    }
}
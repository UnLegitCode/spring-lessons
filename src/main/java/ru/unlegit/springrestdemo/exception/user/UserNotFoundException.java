package ru.unlegit.springrestdemo.exception.user;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public static UserNotFoundException byEmail(String email) {
        return new UserNotFoundException(
                "Пользователь с электронной почтой '%s' не найден".formatted(email)
        );
    }

    public static UserNotFoundException byId(UUID id) {
        return new UserNotFoundException("Пользователь с ID '%s' не найден".formatted(id));
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
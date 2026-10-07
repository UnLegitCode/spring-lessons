package ru.unlegit.springrestdemo.exception.user;

public class UserEmailAlreadyTakenException extends RuntimeException {

    public UserEmailAlreadyTakenException(String email) {
        super("Электронная почта '%s' уже занята другим пользователем".formatted(email));
    }
}
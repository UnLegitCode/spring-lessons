package ru.unlegit.springrestdemo.exception.book;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Книга с ID '%s' не найдена".formatted(id));
    }
}
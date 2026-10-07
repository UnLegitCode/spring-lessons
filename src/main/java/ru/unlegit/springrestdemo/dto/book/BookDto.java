package ru.unlegit.springrestdemo.dto.book;

import java.util.UUID;

public record BookDto(UUID id, String title, String description, UUID authorId) {}
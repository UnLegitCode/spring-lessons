package ru.unlegit.springrestdemo.dto.book;

import java.util.UUID;

public record BookCreateDto(String title, String description, UUID authorId) {}
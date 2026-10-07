package ru.unlegit.springrestdemo.mapper;

import org.springframework.stereotype.Component;
import ru.unlegit.springrestdemo.dto.book.BookCreateDto;
import ru.unlegit.springrestdemo.dto.book.BookDto;
import ru.unlegit.springrestdemo.model.Book;
import ru.unlegit.springrestdemo.model.User;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class BookMapper {

    public BookDto modelToDto(Book model) {
        return new BookDto(
                model.getId(), model.getTitle(), model.getDescription(), model.getAuthor().getId()
        );
    }

    public List<BookDto> modelToDto(List<Book> models) {
        return models.stream()
                .map(this::modelToDto)
                .toList();
    }

    public Book dtoToModel(BookCreateDto dto, Function<UUID, User> userSearchFunc) {
        return Book.builder()
                .title(dto.title())
                .description(dto.description())
                .author(userSearchFunc.apply(dto.authorId()))
                .build();
    }
}
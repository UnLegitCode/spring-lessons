package ru.unlegit.springrestdemo.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.unlegit.springrestdemo.dto.book.BookCreateDto;
import ru.unlegit.springrestdemo.dto.book.BookDto;
import ru.unlegit.springrestdemo.exception.user.UserNotFoundException;
import ru.unlegit.springrestdemo.mapper.BookMapper;
import ru.unlegit.springrestdemo.model.User;
import ru.unlegit.springrestdemo.repository.BookRepository;
import ru.unlegit.springrestdemo.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {

    BookRepository bookRepository;
    UserRepository userRepository;
    BookMapper bookMapper;

    private User resolveAuthor(UUID authorId) {
        return userRepository.findById(authorId)
                .orElseThrow(() -> UserNotFoundException.byId(authorId));
    }

    public BookDto createBook(BookCreateDto dto) {
        var book = bookRepository.save(bookMapper.dtoToModel(dto, this::resolveAuthor));

        return bookMapper.modelToDto(book);
    }

    public List<BookDto> listAuthorBooks(UUID authorId) {
        var books = bookRepository.findAllByAuthor_Id(authorId);

        return bookMapper.modelToDto(books);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
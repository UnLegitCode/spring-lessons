package ru.unlegit.springrestdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.springrestdemo.dto.book.BookCreateDto;
import ru.unlegit.springrestdemo.dto.book.BookDto;
import ru.unlegit.springrestdemo.service.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookCreateDto dto) {
        return bookService.createBook(dto);
    }

    @GetMapping("/by-author/{authorId}")
    public List<BookDto> listAuthorBooks(@PathVariable UUID authorId) {
        return bookService.listAuthorBooks(authorId);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID bookId) {
        bookService.deleteBook(bookId);
    }
}
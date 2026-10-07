package ru.unlegit.springrestdemo.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.unlegit.springrestdemo.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends ListCrudRepository<Book, UUID> {

    List<Book> findAllByAuthor_Id(UUID authorId);
}
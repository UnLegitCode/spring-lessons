package ru.unlegit.springrestdemo.repository;

import org.springframework.data.repository.ListCrudRepository;
import ru.unlegit.springrestdemo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends ListCrudRepository<User, UUID> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
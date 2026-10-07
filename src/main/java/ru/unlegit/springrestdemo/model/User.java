package ru.unlegit.springrestdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    String email;
    @Column(name = "full_name", nullable = false)
    String fullName;
    @Column(name = "password_hash", nullable = false, length = 60)
    String passwordHash;
    @OneToMany(mappedBy = "author")
    List<Book> books;
}
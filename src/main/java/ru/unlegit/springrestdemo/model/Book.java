package ru.unlegit.springrestdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends BaseEntity {

    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    String description;
    @Column(name = "release_year", nullable = false)
    int releaseYear;
    @ManyToOne(optional = false)
    User author;
}
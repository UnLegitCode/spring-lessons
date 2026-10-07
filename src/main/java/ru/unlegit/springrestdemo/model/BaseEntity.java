package ru.unlegit.springrestdemo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    Timestamp updatedAt;
}
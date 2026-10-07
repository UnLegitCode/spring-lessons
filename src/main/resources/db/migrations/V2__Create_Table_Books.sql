CREATE TABLE books
(
    id           UUID         NOT NULL,
    created_at   TIMESTAMP,
    updated_at   TIMESTAMP,
    title        VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    release_year INT          NOT NULL,
    author_id    UUID         NOT NULL,
    CONSTRAINT pk_books PRIMARY KEY (id)
);

ALTER TABLE books
    ADD CONSTRAINT FK_BOOKS_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES users (id);
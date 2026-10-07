CREATE TABLE users
(
    id         UUID         NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    email      VARCHAR(255) NOT NULL,
    full_name  VARCHAR(255) NOT NULL,
    password_hash   VARCHAR(60) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);
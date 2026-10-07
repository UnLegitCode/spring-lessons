package ru.unlegit.springrestdemo.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.unlegit.springrestdemo.dto.user.UserDto;
import ru.unlegit.springrestdemo.dto.user.UserRegisterDto;
import ru.unlegit.springrestdemo.model.User;

@Component
@AllArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserDto modelToDto(User model) {
        return new UserDto(model.getId(), model.getEmail(), model.getFullName());
    }

    public User dtoToModel(UserRegisterDto dto) {
        return User.builder()
                .email(dto.email())
                .fullName(dto.fullName())
                .passwordHash(passwordEncoder.encode(dto.password()))
                .build();
    }
}
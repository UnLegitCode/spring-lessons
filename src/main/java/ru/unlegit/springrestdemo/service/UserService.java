package ru.unlegit.springrestdemo.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.unlegit.springrestdemo.dto.user.UserDto;
import ru.unlegit.springrestdemo.dto.user.UserLoginDto;
import ru.unlegit.springrestdemo.dto.user.UserRegisterDto;
import ru.unlegit.springrestdemo.exception.user.UserAuthenticationException;
import ru.unlegit.springrestdemo.exception.user.UserEmailAlreadyTakenException;
import ru.unlegit.springrestdemo.exception.user.UserNotFoundException;
import ru.unlegit.springrestdemo.mapper.UserMapper;
import ru.unlegit.springrestdemo.repository.UserRepository;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserDto register(UserRegisterDto dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new UserEmailAlreadyTakenException(dto.email());
        }

        var user = userRepository.save(userMapper.dtoToModel(dto));

        return userMapper.modelToDto(user);
    }

    public UserDto login(UserLoginDto dto) {
        var user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> UserNotFoundException.byEmail(dto.email()));

        if (!passwordEncoder.matches(dto.password(), user.getPasswordHash())) {
            throw new UserAuthenticationException();
        }

        return userMapper.modelToDto(user);
    }
}
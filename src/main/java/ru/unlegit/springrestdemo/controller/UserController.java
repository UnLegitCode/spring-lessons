package ru.unlegit.springrestdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.unlegit.springrestdemo.dto.user.UserDto;
import ru.unlegit.springrestdemo.dto.user.UserLoginDto;
import ru.unlegit.springrestdemo.dto.user.UserRegisterDto;
import ru.unlegit.springrestdemo.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto register(@RequestBody UserRegisterDto dto) {
        return userService.register(dto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody UserLoginDto dto) {
        return userService.login(dto);
    }
}
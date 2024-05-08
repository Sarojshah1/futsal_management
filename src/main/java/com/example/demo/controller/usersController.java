package com.example.demo.controller;

import com.example.demo.entity2.User;
import com.example.demo.pojo.UserPojo;
import com.example.demo.service.UsersServices;
import com.example.demo.shared.pojo.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class usersController {

    private final UsersServices userService;

    @GetMapping
    public GlobalApiResponse<List<User>> getAllUsers() {
        return GlobalApiResponse
                .<List<User>>builder()
                .data(userService.getAllUsers())
                .statusCode(200)
                .message("Users retrieved successfully")
                .build();
    }

    @PostMapping
    public GlobalApiResponse<String> saveUser(@RequestBody @Valid UserPojo userPojo) {
        User user = new User();
        user.setId(userPojo.getId());
        user.setName(userPojo.getName());
        userService.saveUser(user);
        return GlobalApiResponse
                .<String>builder()
                .data("saved")
                .statusCode(200)
                .message("User saved successfully")
                .build();
    }

    @PutMapping("/{id}")
    public GlobalApiResponse<String> updateUser(@PathVariable Integer id, @RequestBody @Valid UserPojo userPojo) {
        User user = new User();
        user.setId(id);
        user.setName(userPojo.getName());
        userService.saveUser(user);
        return GlobalApiResponse
                .<String>builder()
                .data("updated")
                .statusCode(200)
                .message("User updated successfully")
                .build();
    }

    @GetMapping("/{id}")
    public GlobalApiResponse<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));
        return user.map(value ->
                        GlobalApiResponse.<User>builder()
                                .data(value)
                                .statusCode(200)
                                .message("User retrieved successfully")
                                .build())
                .orElseGet(() ->
                        GlobalApiResponse.<User>builder()
                                .statusCode(404)
                                .message("User not found")
                                .build());
    }

    @DeleteMapping("/{id}")
    public GlobalApiResponse<String> deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return GlobalApiResponse
                .<String>builder()
                .data("deleted")
                .statusCode(200)
                .message("User deleted successfully")
                .build();
    }
}

package com.example.demo.service;

import com.example.demo.entity2.User;

import java.util.List;

public interface UsersServices {
    User getUserById(Integer id);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUserById(Integer id);
}

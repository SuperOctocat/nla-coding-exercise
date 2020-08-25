package com.example.nlacodingexercise.service;

import com.example.nlacodingexercise.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUser(Long id);

    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}







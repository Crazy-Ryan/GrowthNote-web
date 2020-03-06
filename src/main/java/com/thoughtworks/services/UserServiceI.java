package com.thoughtworks.services;

import com.thoughtworks.entities.User;

import java.util.List;

public interface UserServiceI {
    User getUserByNameAndPassword(String name, String password);

    User userRegister(String name, String password);

    List<User> getUsers();
}

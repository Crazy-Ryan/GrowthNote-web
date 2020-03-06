package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

import java.util.List;

public interface UserRepositoryI {
    User getUserByNameAndPassword(String name, String password);

    User userRegister(User user);

    List<User> getUsers();
}

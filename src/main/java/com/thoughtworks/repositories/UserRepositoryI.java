package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

import java.util.List;

public interface UserRepositoryI {
    User getUserByNameAndPassword(String userName, String password);

    void userRegister(User user);

    List<User> getUsers();

}

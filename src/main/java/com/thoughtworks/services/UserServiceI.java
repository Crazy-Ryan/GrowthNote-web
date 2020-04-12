package com.thoughtworks.services;

import com.thoughtworks.entities.User;

import java.util.List;

public interface UserServiceI {
    User getUserByNameAndPassword(String userName, String password);

    void userRegister(String userName, String password);

    List<User> getUsers();

}

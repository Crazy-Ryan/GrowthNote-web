package com.thoughtworks.controllers;


import com.thoughtworks.entities.User;
import com.thoughtworks.services.UserService;
import com.thoughtworks.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private UserServiceI userService = new UserService();

    @GetMapping("")
    public ResponseEntity<User> getUserByNameAndPassword(@PathParam("userName") String userName, @PathParam("password") String password) {
        User user = userService.getUserByNameAndPassword(userName, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity userRegister(@RequestBody User user) {
        userService.userRegister(user.getUserName(), user.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> UserList = userService.getUsers();
        return ResponseEntity.ok(UserList);
    }

}

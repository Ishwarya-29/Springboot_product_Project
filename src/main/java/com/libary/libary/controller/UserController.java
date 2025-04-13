package com.libary.libary.controller;

import com.libary.libary.entity.User;
import com.libary.libary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers()
    {
        return userService.getAllUser();
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PutMapping("/updateUserName/{id}")
    public User UpadteUser(@PathVariable Long id,@RequestBody User user)
    {
        return userService.updateUserDetails(id,user);
    }
}

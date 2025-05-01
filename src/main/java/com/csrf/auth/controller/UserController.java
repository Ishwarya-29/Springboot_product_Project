package com.csrf.auth.controller;

import com.csrf.auth.Service.UserService;
import com.csrf.auth.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    UserService userService;
    @PostMapping("admin/adduser")
    public void addUser(@RequestBody Users users)
    {
        userService.adduser(users);
    }
}

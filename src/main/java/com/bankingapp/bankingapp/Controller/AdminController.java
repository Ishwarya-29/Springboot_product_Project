package com.bankingapp.bankingapp.Controller;

import com.bankingapp.bankingapp.Entity.Users;
import com.bankingapp.bankingapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    UserService userService;

    @PostMapping("admin/adduser")
    public void addUser(@RequestBody Users users) {
        userService.adduser(users);

    }

}
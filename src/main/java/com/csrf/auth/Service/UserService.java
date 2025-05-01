package com.csrf.auth.Service;

import com.csrf.auth.Repository.UserRepository;
import com.csrf.auth.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(10);
    @Autowired
    UserRepository userrepo;
    public void adduser(Users users)
    {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userrepo.save(users);
    }
}

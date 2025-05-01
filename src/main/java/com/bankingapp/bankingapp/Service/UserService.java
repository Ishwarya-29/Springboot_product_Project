package com.bankingapp.bankingapp.Service;
import com.bankingapp.bankingapp.Entity.Users;
import com.bankingapp.bankingapp.Repository.UserRepository;
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

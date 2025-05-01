package com.bankingapp.bankingapp.Service;
import com.bankingapp.bankingapp.Entity.UserPrincipal;
import com.bankingapp.bankingapp.Entity.Users;
import com.bankingapp.bankingapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    public UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=userRepo.getByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Users not found");
        }
        return new UserPrincipal(user);
    }
}

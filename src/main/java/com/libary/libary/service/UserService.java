package com.libary.libary.service;

import com.libary.libary.entity.User;
import com.libary.libary.exception.InvalidMobileNumber;
import com.libary.libary.exception.ResourceNotFound;
import com.libary.libary.exception.UserExist;
import org.springframework.beans.factory.annotation.Autowired;
import com.libary.libary.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public boolean existsByPhoneNumber(String phoneNumber) {
        return userRepo.existsByPhoneNumber(phoneNumber);
    }

    public User createUser(User user) {
        // Validate phone number length
        if (user.getPhoneNumber().length() != 10) {
            throw new InvalidMobileNumber("Phone number must be exactly 10 digits long.");
        }

        if (userRepo.existsByPhoneNumber(user.getPhoneNumber())) {
            throw new UserExist("User with this phone number already exists.");
        }

        // Save the new user
        return userRepo.save(user);
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User updateUserDetails(Long userId, User updateReq) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id " + userId));
        if (!user.getPhoneNumber().equals(updateReq.getPhoneNumber())) {
            if (userRepo.existsByPhoneNumber(updateReq.getPhoneNumber())) {
                throw new UserExist("User with this phone number already exists.");
            }
        }

        user.setName(updateReq.getName());
        user.setPhoneNumber(updateReq.getPhoneNumber());
        return userRepo.save(user);
    }

}

package com.libary.libary.repository;

import com.libary.libary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User,Long>{
    boolean existsByPhoneNumber(String phoneNumber);
}

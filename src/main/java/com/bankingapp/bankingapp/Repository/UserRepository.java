package com.bankingapp.bankingapp.Repository;
import com.bankingapp.bankingapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    public Users getByUsername(String username);
}

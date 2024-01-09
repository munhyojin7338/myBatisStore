package com.example.mybatisStore.user.repository;

import com.example.mybatisStore.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(String username);
    Optional<User> findByEmail(String username);


}

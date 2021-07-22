package com.example.demo.loginSecurity.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {
    public Optional<User> findByUsername(String username);
}

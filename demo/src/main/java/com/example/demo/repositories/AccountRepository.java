package com.example.demo.repositories;

import com.example.demo.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // custom query to search to blog post by title or content
    Optional<Account> findByUsername(String username);    
}
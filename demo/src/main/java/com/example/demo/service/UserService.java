package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entities.User;

@Service
public interface UserService {
    public void saveUser(User user);

    public User loadById(Integer id);

    public void updateUser(User user);
    
}
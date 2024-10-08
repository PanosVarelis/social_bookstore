package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;

@Service
public interface AccountService {
    public void saveAccount(Account account);

    public boolean isAccountPresent(Account account);
}

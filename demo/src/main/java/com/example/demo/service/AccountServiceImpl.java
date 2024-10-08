package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Account;
import com.example.demo.repositories.AccountRepository;



@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveAccount(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
		account.setRole("USER");
        accountRepository.save(account);	
    }

    @Override
	public boolean isAccountPresent(Account account) {
		Optional<Account> storedAccount = accountRepository.findByUsername(account.getUsername());
		return storedAccount.isPresent();
	}

	// Method defined in Spring Security UserDetailsService interface
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// orElseThrow method of Optional container that throws an exception if Optional result  is null
		return accountRepository.findByUsername(username).orElseThrow(
	                ()-> new UsernameNotFoundException(
	                        String.format("USER_NOT_FOUND %s", username)
	                ));
	}
}


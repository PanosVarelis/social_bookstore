package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AccountDto;
import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRespository;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;

@Controller
public class AccountController {
	
    @Autowired
	AccountService accountService;

	@Autowired
	AccountRepository accountRespository;


    @Autowired
    UserService userService;

    @Autowired
    UserRespository userRespository;

	@RequestMapping("/login")
    public String login(){
        return "auth/login";
    }

	@RequestMapping("/register")
	public String register(Model model){
		AccountDto account = new AccountDto();
		model.addAttribute("account", account);
		return "auth/register";
	}

	@RequestMapping("/register/save")
    public String registerAccount(@ModelAttribute("account") Account account, Model model){

        if(accountService.isAccountPresent(account)){
            model.addAttribute("successMessage", "User already registered!");
            return "auth/register";
        }

        accountService.saveAccount(account);
        model.addAttribute("successMessage", "User registered successfully!");
        User user = new User(accountRespository.findByUsername(account.getUsername()).get().getId());

        userService.saveUser(user);


        return "auth/login";
    }
}
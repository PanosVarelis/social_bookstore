package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRespository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public void saveUser(User user) {
        System.err.println(user.getAccountId());
        userRespository.save(user);
    }

    @Override
    public User loadById(Integer id) {
        Optional<User> user = userRespository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public void updateUser(User user){
        userRespository.updateQuery(user.getName(), user.getAdress(), 
                                    user.getAge(), user.getCategories(), 
                                    user.getAuthors(), user.getPhoneNumber(),
                                    user.getAccountId());
    }
    
}



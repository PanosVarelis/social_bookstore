package com.example.demo.repositories;

import com.example.demo.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRespository extends JpaRepository<User, Integer> {

    // custom query to search to blog post by title or content
    Optional<User> findById(int id);

    @Modifying
    @Transactional
    @Query("update User u set u.name = :name, u.adress = :adress, u.age = :age, u.categories = :categories, u.authors = :authors, u.phoneNumber = :phoneNumber where u.id = :id")
    public void updateQuery(@Param(value = "name") String name, 
                            @Param(value = "adress") String adress, 
                            @Param(value = "age") Integer age, 
                            @Param(value = "categories") String categories, 
                            @Param(value = "authors") String authors, 
                            @Param(value="phoneNumber") String phoneNumber, 
                            @Param(value="id") Integer id);
}
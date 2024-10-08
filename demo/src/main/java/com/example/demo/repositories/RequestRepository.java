package com.example.demo.repositories;

import com.example.demo.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Transactional
    @Query(value="select * from request r where r.account_id=:accountId", nativeQuery = true)
    public List<Request> requestById(@Param(value = "accountId") Integer accountId);

    @Transactional
    @Query(value="select * from request r where r.account_id=:accountId limit 5", nativeQuery = true)
    public List<Request> requestByIdtop(@Param(value = "accountId") Integer accountId);
    
}
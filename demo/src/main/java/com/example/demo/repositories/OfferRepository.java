package com.example.demo.repositories;

import com.example.demo.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {

    // custom query to search to blog post by title or content
    @Transactional
    @Query(value="select * from offer o where o.account_id=:accountId", nativeQuery = true)
    public List<Offer> offerById(@Param(value = "accountId") Integer accountId);

    @Transactional
    @Query(value="select * from offer o where o.account_id=:accountId limit 5", nativeQuery = true)
    public List<Offer> offerByIdtop(@Param(value = "accountId") Integer accountId);

    @Transactional
    @Query(value="select * from offer o where not o.account_id=:accountId", nativeQuery = true)
    public List<Offer> offerByDiffId(@Param(value = "accountId") Integer accountId);
}
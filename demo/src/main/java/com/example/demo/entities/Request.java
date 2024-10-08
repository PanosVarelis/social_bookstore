package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Request {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer accountId;
    private Integer bookId;

    public Request(Integer accountId, Integer bookId){
        this.accountId = accountId;
        this.bookId = bookId;
    }

    public Request(Integer id, Integer accountId, Integer bookId){
        this.id = id;
        this.accountId = accountId;
        this.bookId = bookId;
    }

    public Request(){
        id = -1;
    }

    public Request(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}

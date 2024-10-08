package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Offer {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private Integer accountId;
  private String title;
  private String authors;
  private String category;
  private String summary;
  
  public Offer(Integer accountId, String title, String authors, String category, String summary){
    this.accountId = accountId;
    this.title = title;
    this.authors = authors;
    this.category = category;
    this.summary = summary;
  }

  public Offer(Integer id, Integer accountId, String title, String authors, String category, String summary){
    this.id = id;
    this.accountId = accountId;
    this.title = title;
    this.authors = authors;
    this.category = category;
    this.summary = summary;
  }

  public Offer(){
    id = -1;
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
    this.accountId= accountId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthors() {
    return authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public String getCategory(){
    return category;
  }

  public void setCategory(String category){
    this.category = category;
  }

  public String getSummary(){
    return summary;
  }

  public void setSummary(String summary){
    this.summary = summary;
  }

  public boolean notNull(){
    if (title.isEmpty() || authors.isEmpty() || category.isEmpty() || summary.isEmpty())
    {
      return false;
    }
    return true;
  }
}
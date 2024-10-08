package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer accountId;
  private String name;
  private String adress;
  private Integer age;
  private String phoneNumber;
  private String categories;
  private String authors;

  //@OneToOne(mappedBy = "user")
  //public Account account;

  public User(String name, String adress, Integer age, String phoneNumber, String categories, String authors){
    this.name = name;
    this.adress = adress;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.categories = categories;
    this.authors = authors;
  }

  public User(Integer accountId, String name, String adress, Integer age, String phoneNumber, String categories, String authors){
    this.accountId = accountId;
    this.name = name;
    this.adress = adress;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.categories = categories;
    this.authors = authors;
  }

  public User(Integer accountId){
    this.accountId = accountId;
  }

  public User(){

  }

  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountIdd) {
    this.accountId = accountIdd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Integer getAge(){
    return age;
  }

  public void setAge(Integer age){
    this.age = age;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public String getCategories(){
    return categories;
  }

  public void setCategories(String categories){
    this.categories = categories;
  }

  public String getAuthors(){
    return authors;
  }

  public void setAuthors(String authors){
    this.authors = authors;
  }
}
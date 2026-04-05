package com.yernar.finance_tracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private String title;      // "Lunch", "Salary"
    private float amount;      // 250.00
    private String type;       // "INCOME" or "EXPENSE"
    private String category;   // "FOOD", "TRANSPORT"
    private String date;       // "2026-04-05"
    public Transaction(String title, String type,float amount,String category,String date){
        this.title=title;
        this.type=type;
        this.amount=amount;
        this.category=category;
        this.date=date;
    }
    public Transaction(){}

    //Getters
    public String getTitle(){
        return title;
    }

    public float getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }
    //Setters
    public void setId(Long id){
        this.id=id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.assignment.expensetrackingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expenses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private long expenseId;
   private String expenseType;
   private String expenseAmount;
   private String date;
public long getExpenseId() {
	return expenseId;
}
public void setExpenseId(long expenseId) {
	this.expenseId = expenseId;
}
public String getExpenseType() {
	return expenseType;
}
public void setExpenseType(String expenseType) {
	this.expenseType = expenseType;
}
public String getExpenseAmount() {
	return expenseAmount;
}
public void setExpenseAmount(String expenseAmount) {
	this.expenseAmount = expenseAmount;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
   

}

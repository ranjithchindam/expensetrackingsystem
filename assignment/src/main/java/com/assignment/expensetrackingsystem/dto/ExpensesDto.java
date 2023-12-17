package com.assignment.expensetrackingsystem.dto;

public class ExpensesDto {
	   private String expenseType;
	   private String expenseAmount;
	   private String date;
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

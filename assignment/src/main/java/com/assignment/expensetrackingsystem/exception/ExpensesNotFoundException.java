package com.assignment.expensetrackingsystem.exception;

public class ExpensesNotFoundException extends RuntimeException {
    private String message;
    private String date;
	public ExpensesNotFoundException(String string, String date) {
		this.message=string;
		this.date=date;
	}
	public ExpensesNotFoundException(String string) {
		this.message=string;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
  
}

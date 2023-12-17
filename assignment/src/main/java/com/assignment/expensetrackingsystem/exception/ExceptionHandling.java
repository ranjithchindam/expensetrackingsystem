package com.assignment.expensetrackingsystem.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.expensetrackingsystem.entity.Expenses;
import com.assignment.expensetrackingsystem.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> expensesNotFoundException(ExpensesNotFoundException ex)
	{
    	List<String> listExpenses=new ArrayList<String>();
    	listExpenses.add(ex.getMessage());
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Your don't have Expenses");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setObject(listExpenses);
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}

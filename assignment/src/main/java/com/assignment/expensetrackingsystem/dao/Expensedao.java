package com.assignment.expensetrackingsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.assignment.expensetrackingsystem.entity.Expenses;
import com.assignment.expensetrackingsystem.repository.ExpenseRepository;
import com.assignment.expensetrackingsystem.util.ResponseStructure;

public class Expensedao {
    @Autowired
    public ExpenseRepository repository;
	public com.assignment.expensetrackingsystem.entity.Expenses saveExpense(
			com.assignment.expensetrackingsystem.entity.Expenses expenses) {
		return repository.save(expenses);
	}
	public List<Expenses> getExpenseByDate(String date) {
		 List<Expenses> dbExpense = repository.getExpenseUsingDate(date);
		return dbExpense;
	}
	public List<Expenses> getAllExpense() {
		return repository.findAll();
	}
	public void deleteExpenseById(long expenseId) {
		repository.deleteById(expenseId);
	}
	public Expenses getExpenseById(Long expenseId) {
		return repository.getReferenceById(expenseId);
	}

}

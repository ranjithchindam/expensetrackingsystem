package com.assignment.expensetrackingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.expensetrackingsystem.entity.Expenses;

public interface ExpenseRepository extends JpaRepository<Expenses, Long>{
	@Query("select p from  Expenses p where p.date=?1")
  List<Expenses> getExpenseUsingDate(String date);
	@Query("select p from Expenses p where p.expenseId=?1")
  List<Expenses> getExpenseById(Long expenseId);
}

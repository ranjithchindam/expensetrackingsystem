package com.assignment.expensetrackingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.expensetrackingsystem.dto.ExpensesDto;
import com.assignment.expensetrackingsystem.service.ExpenseService;
import com.assignment.expensetrackingsystem.util.ResponseStructure;

@RestController
@RequestMapping("Expenses")
public class ExpenseController {
	@Autowired
	public ExpenseService service;
	@PostMapping("save")
 public ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>> saveExpense(@RequestBody ExpensesDto expenseDto)
 {
	 return service.saveExpense(expenseDto);
 }
	@GetMapping("GetExpenses")
 public ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>> getExpense(@RequestParam String date)
 {
	return service.getExpense(date);
 }
	@DeleteMapping("deleteExpense")
 public ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>> deleteExpense(@RequestParam Long expenseId)
 {
		return service.deleteExpense(expenseId);
 }
	@PutMapping("UpdateExpense")
 public ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>> updateExpense(@RequestParam Long expenseId,@RequestBody ExpensesDto expensesDto)
 {
		return service.updateExpense(expenseId,expensesDto);
 }
}

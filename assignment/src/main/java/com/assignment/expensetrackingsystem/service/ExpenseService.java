package com.assignment.expensetrackingsystem.service;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.expensetrackingsystem.dao.Expensedao;
import com.assignment.expensetrackingsystem.dto.ExpensesDto;
import com.assignment.expensetrackingsystem.entity.Expenses;
import com.assignment.expensetrackingsystem.exception.ExpensesNotFoundException;
import com.assignment.expensetrackingsystem.util.ResponseStructure;

@Service
public class ExpenseService {
   @Autowired
   public Expensedao expensedao;
   @Autowired
   ModelMapper modelMapper;
public ResponseEntity<ResponseStructure<Expenses>> saveExpense(ExpensesDto expenseDto) {
	     Expenses expenses = modelMapper.map(expenseDto, Expenses.class);
	     Expenses dbExpense = expensedao.saveExpense(expenses);
	    if (expenses!=null)
		{
	    	List<Expenses> listExpenses=new ArrayList<Expenses>();
			ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses> responseStructure=new ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>();
			responseStructure.setMessage("Expense Saeved succesfully");
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			listExpenses.add(dbExpense);
			responseStructure.setObject(listExpenses);
		    return new ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>>(responseStructure, HttpStatus.ACCEPTED);
		}
	    return null;
}
public ResponseEntity<ResponseStructure<Expenses>> getExpense(String date) {
	List<Expenses> dbExpense = expensedao.getExpenseByDate(date);
    if (dbExpense.isEmpty())
	{
        throw new ExpensesNotFoundException("Expense Not present based on the "+date,date);
	}
    ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses> responseStructure=new ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>();
	responseStructure.setMessage("Expense fetched succesfully");
	responseStructure.setStatus(HttpStatus.FOUND.value());
	responseStructure.setObject(dbExpense);
    return new ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>>(responseStructure, HttpStatus.FOUND);
}
public ResponseEntity<ResponseStructure<Expenses>> deleteExpense(Long expenseId) {
	Expenses dbExpense = expensedao.getExpenseById(expenseId);
	    if (dbExpense!=null)
	    {
	    	List<Expenses> listExpenses=new ArrayList<Expenses>();
	    	listExpenses.add(dbExpense);
	    	expensedao.deleteExpenseById(expenseId);
			ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses> responseStructure=new ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>();
			responseStructure.setMessage("Expense deleted succesfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setObject(listExpenses);
		    return new ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>>(responseStructure, HttpStatus.FOUND);
	    }
	    throw new ExpensesNotFoundException("Expense Not present based on the Id "+expenseId.toString());
}
public ResponseEntity<ResponseStructure<Expenses>> updateExpense(Long expenseId, ExpensesDto expensesDto) {
	Expenses dbExpense = expensedao.getExpenseById(expenseId);
	if (dbExpense!=null)
    {
		Expenses expenses=new Expenses();
		expenses.setExpenseId(dbExpense.getExpenseId());
		expenses.setDate(expensesDto.getDate());
		expenses.setExpenseAmount(expensesDto.getExpenseAmount());
		expenses.setExpenseType(expensesDto.getExpenseType());
    	List<Expenses> listExpenses=new ArrayList<Expenses>();
    	listExpenses.add(expenses);
    	expensedao.saveExpense(expenses);
		ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses> responseStructure=new ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>();
		responseStructure.setMessage("Expense Updated succesfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setObject(listExpenses);
	    return new ResponseEntity<ResponseStructure<com.assignment.expensetrackingsystem.entity.Expenses>>(responseStructure, HttpStatus.FOUND);
    }
	throw new ExpensesNotFoundException("Expense Not present based on the Id "+expenseId.toString());
}
}


   
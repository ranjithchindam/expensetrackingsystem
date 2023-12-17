package com.assignment.expensetrackingsystem.util;

import java.util.List;

public class ResponseStructure<Object> {
  public int status;
  public String message;
  public List<Object> object;
  

public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<Object> getObject() {
	return object;
}
public void setObject(List<Object> object) {
	this.object = object;
}

  
}

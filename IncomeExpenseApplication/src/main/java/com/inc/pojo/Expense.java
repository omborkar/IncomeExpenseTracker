package com.inc.pojo;

public class Expense {
	private double expense;
	private int id;
	private String description;
	private String expenseType;
	private int userId;
	private String expenseDate;
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		this.expenseDate = expenseDate;
	}
	@Override
	public String toString() {
		return "Expense [expense=" + expense + ", id=" + id + ", description=" + description + ", expenseType="
				+ expenseType + ", userId=" + userId + ", expenseDate=" + expenseDate + "]";
	}
	
	 

}

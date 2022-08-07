package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inc.pojo.Expense;
import com.inc.pojo.Income;
import com.inc.util.DBConnect;

public class ExpenseDao {
	

	Connection con = DBConnect.getConnection();  // connecton class obj with db connect class amd get connection method
	
	public boolean addExpense(Expense exp) {    //method to add income with pojo income class and object of that as param
		
		String sql = "Insert into expense (expense,expense_type,description,user_id) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, exp.getExpense());  // saveing in database useint set and get from income inc
			ps.setString(2, exp.getExpenseType());
			ps.setString(3, exp.getDescription());
			ps.setInt(4, exp.getUserId());
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	return false;	
	}
	
	
	
	public boolean updateExpense(Expense exp) {    

		String sql = "update expense set expense=?,expense_type=?,description=?,user_id=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, exp.getExpense()); 
			ps.setString(2, exp.getExpenseType());
			ps.setString(3, exp.getDescription());
			ps.setInt(4, exp.getUserId());
			ps.setInt(5, exp.getId());
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}	
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return false;	
	}
	
	
	
	public List<Expense> getExpenseList(int uid){
		String sql = "select * from expense where user_id=?";
		List<Expense> explist=new ArrayList<Expense>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Expense inc = new Expense();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				inc.setExpense(rs.getInt("expense"));
				inc.setExpenseDate(rs.getDate("expense_date").toString());
				inc.setExpenseType(rs.getString("expense_type"));
				inc.setUserId(rs.getInt("user_id"));
				explist.add(inc);
				
			}
			return explist; 

		}
		catch (Exception e) {
			e.printStackTrace();
		}

    return null;
	}
	
	
	public boolean deleteExpense(int id) {    //method to delete income using id from income list

		String sql = "delete from expense where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, id);  
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}	
		}
		catch (Exception e){
			e.printStackTrace();
		}

		return false;	
	}
	
	public Expense getExpense(int id){
		String sql = "select * from expense where id=?";
		Expense exp = new Expense();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				exp.setId(rs.getInt("id"));
				exp.setDescription(rs.getString("description"));
				exp.setExpense(rs.getInt("expense"));
				exp.setExpenseDate(rs.getDate("expense_date").toString());
				exp.setExpenseType(rs.getString("expense_type"));
				exp.setUserId(rs.getInt("user_id"));
				return exp;

			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<Expense> getExpenseListByDescription(int uid,String description){
		String sql="select * from expense where user_id=? and description like '%"+description+"%'";
		List<Expense> explist=new ArrayList<Expense>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,uid);
            ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Expense exp=new Expense();
				exp.setId(rs.getInt("id"));
				exp.setDescription(rs.getString("description"));
				exp.setExpense(rs.getDouble("expense"));
				exp.setExpenseDate(rs.getDate("expense_date").toString());
				exp.setExpenseType(rs.getString("expense_type"));
				exp.setUserId(rs.getInt("user_id"));
				explist.add(exp);
			}
			return explist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Expense> getExpenseListByType(int uid,String type){
		String sql="select * from expense where user_id=? and expense_type=?";
		List<Expense> explist=new ArrayList<Expense>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,uid);
			ps.setString(2,type);
            ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Expense exp=new Expense();
				exp.setId(rs.getInt("id"));
				exp.setDescription(rs.getString("description"));
				exp.setExpense(rs.getDouble("expense"));
				exp.setExpenseDate(rs.getDate("expense_date").toString());
				exp.setExpenseType(rs.getString("expense_type"));
				exp.setUserId(rs.getInt("user_id"));
				explist.add(exp);
			}
			return explist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	



}

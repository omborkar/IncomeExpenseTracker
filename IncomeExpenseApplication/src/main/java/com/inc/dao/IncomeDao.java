package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inc.pojo.Income;
import com.inc.util.DBConnect;
import com.mysql.cj.protocol.Resultset;

public class IncomeDao {

	Connection con = DBConnect.getConnection();  // connecton class obj with db connect class amd get connection method

	public boolean addIncome(Income inc) {    //method to add income with pojo income class and object of that as param

		String sql = "Insert into income (income,income_type,description,user_id) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, inc.getIncome());  // saveing in database useint set and get from income inc
			ps.setString(2, inc.getIncomeType());
			ps.setString(3, inc.getDescription());
			ps.setInt(4, inc.getUserId());
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


	public List<Income> getIncomeList(int uid){
		String sql = "select * from income where user_id=?";
		List<Income> inclist=new ArrayList<Income>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Income inc = new Income();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				inc.setIncome(rs.getInt("income"));
				inc.setIncomeDate(rs.getDate("income_date").toString());
				inc.setIncomeType(rs.getString("income_type"));
				inc.setUserId(rs.getInt("user_id"));
				inclist.add(inc);

			}
			return inclist; 

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteIncome(int id) {    //method to delete income using id from income list

		String sql = "delete from income where id=?";
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


	public Income getIncome(int id){
		String sql = "select * from income where id=?";
		Income inc = new Income();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				inc.setIncome(rs.getInt("income"));
				inc.setIncomeDate(rs.getDate("income_date").toString());
				inc.setIncomeType(rs.getString("income_type"));
				inc.setUserId(rs.getInt("user_id"));
				return inc;

			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}



	public boolean updateIncome(Income inc) {    

		String sql = "update income set income=?,income_type=?,description=?,user_id=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, inc.getIncome()); 
			ps.setString(2, inc.getIncomeType());
			ps.setString(3, inc.getDescription());
			ps.setInt(4, inc.getUserId());
			ps.setInt(5, inc.getId());
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
	
	
	public List<Income> getIncomeListByDescription(int uid,String description){
		String sql="select * from income where user_id=? and description like '%"+description+"%'";
		List<Income> inclist=new ArrayList<Income>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,uid);
            ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Income inc=new Income();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				inc.setIncome(rs.getDouble("income"));
				inc.setIncomeDate(rs.getDate("income_date").toString());
				inc.setIncomeType(rs.getString("income_type"));
				inc.setUserId(rs.getInt("user_id"));
				inclist.add(inc);
			}
			return inclist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Income> getIncomeListByType(int uid,String type){
		String sql="select * from income where user_id=? and income_type=?";
		List<Income> inclist=new ArrayList<Income>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,uid);
			ps.setString(2,type);
            ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Income inc=new Income();
				inc.setId(rs.getInt("id"));
				inc.setDescription(rs.getString("description"));
				inc.setIncome(rs.getDouble("income"));
				inc.setIncomeDate(rs.getDate("income_date").toString());
				inc.setIncomeType(rs.getString("income_type"));
				inc.setUserId(rs.getInt("user_id"));
				inclist.add(inc);
			}
			return inclist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public double getBalance(int user_id) {
		String sql1="select sum(income) as totalIncome from income where user_id="+user_id;
		try {
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				double totalIncome=rs.getDouble("totalIncome");
				String sql2="select sum(expense) as totalexpense from expense where user_id="+user_id;
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()) {
					double totalExpense=rs2.getDouble("totalExpense");
					return totalIncome-totalExpense;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

}

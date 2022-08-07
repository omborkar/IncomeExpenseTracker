package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.inc.pojo.User;
import com.inc.util.DBConnect;

public class UserDao {

	Connection con = DBConnect.getConnection();

	public boolean adduser(String email, String passw) {

		String sql = "insert into user(email,password) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, passw);
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<User> getUserList() {
		String sql = "Select * from user";
		List<User> ul = new ArrayList<User>();
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
				ul.add(u);
			}
			return ul;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	
	public User userLogin(String email,String passw) {
		String sql = "Select * from user where email=? and password=?";
		User u = new User();
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, passw);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setContact(rs.getString("contact"));
				u.setPassword(rs.getString("password"));
				return u;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public boolean updateUser(User u) {
		String sql = "update  user set name=?,email=?,contact=?,password=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getContact());
			ps.setString(4, u.getPassword());
			ps.setInt(5, u.getId());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	

}

package com.inc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() {
		Connection con= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_income_expense","Omborkar2000","Omborkar2000");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_income_expense","root","");
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return con;
	}

}


/*

for git bash learcode folder open gitbash ---

ssh -i "learncode.pem" ubuntu@ec2-23-22-245-124.compute-1.amazonaws.com

for starting tomecat-

sudo systemctl start tomcat

sudo systemctl stop tomcat


*/
package JDBC;

import java.util.*; 
import java.sql.CallableStatement;
import java.sql.*;  

class JDBC{
	public static void main(String args[]){  
		try{  
			List<Doctor> doctor = new ArrayList<Doctor>();
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Omkar@1996"); 

			CallableStatement cStmt = con.prepareCall("{call doctor_patient()}");
			cStmt.execute();
			
	          ResultSet resultSet = cStmt.getResultSet();
	          while (resultSet.next()) {
	        	  Doctor doc = new Doctor();
	        	  doc.setD_id(resultSet.getInt("d_id"));
	        	  doc.setD_name(resultSet.getString("d_name"));
	        	  doc.setP_id(resultSet.getInt("p_id"));
	        	  doc.setP_name(resultSet.getString("p_name"));
	        	  doc.setP_d_id(resultSet.getInt("p_d_id"));
	        	  System.out.println(doc.toString());
	        	  doctor.add(doc);
	          }
			con.close();  
			}
		catch(Exception e){ System.out.println(e);}  
			}  
}  
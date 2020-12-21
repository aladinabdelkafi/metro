package metro.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect {
	public static Connection cnx=null;
	static 	String url = "jdbc:mysql://localhost:3306/metro"; 

	public static Connection getConnection(){
		
		 try
		    {  
		        Class.forName("com.mysql.jdbc.Driver");  
		         cnx=DriverManager.getConnection(url,"root","");  
		    }

		    catch(Exception e)
		    {
		        System.out.println(e);
		    }
		 return cnx;
	}
		         
		

}

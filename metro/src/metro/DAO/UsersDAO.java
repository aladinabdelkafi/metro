package metro.DAO;

import java.sql.*;
import java.util.ArrayList;

import metro.model.Users;

public class UsersDAO 
{
	
	public static Connection cnx;
	
	public UsersDAO() {
		cnx=Connect.getConnection();

	}
	public static Users find(String login)
	{
		try
		{		cnx=Connect.getConnection();
		//System.out.println("cnxxx="+cnx);
			Users u = null;
			PreparedStatement ps = cnx.prepareStatement("select * from users where user_name=?");
			ps.setString(1, login);
			ResultSet res = ps.executeQuery();
			if(res.next())
			{
				u = new Users(login, res.getString(2), res.getString(3));
			}
			ps.close();

			return u!=null ? u : null;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static ArrayList<Users> findAll()
	{
		try
		{
			cnx = DAOConnection.getConnection();
			ArrayList<Users> list = new ArrayList<Users>();
			PreparedStatement ps = cnx.prepareStatement("select * from users");
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				Users u = new Users(res.getString(1), res.getString(2), res.getString(3));
				list.add(u);
			}
			ps.close(); res.close();
			DAOConnection.close();

			return list;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static boolean add(Users u)
	{
		try
		{
			cnx = DAOConnection.getConnection();
		    PreparedStatement ps = cnx.prepareStatement("insert into Users values(?,?,?)");
		    ps.setString(1, u.getLogin());
		    ps.setString(2, u.getPassword());
		    ps.setString(3, u.getRole());  

		    int i = ps.executeUpdate();
		    
		    ps.close();
		    DAOConnection.close();
		    if(i>0)
			    return true;
		    return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean delete(Users u)
	{
		try
		{
			cnx = DAOConnection.getConnection();
		    PreparedStatement ps = cnx.prepareStatement("delete from Users where login=?");
		    ps.setString(1, u.getLogin());
		    int i = ps.executeUpdate();
		    ps.close();
		    DAOConnection.close();
		    if(i>0)
			    return true;
		    return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean update(String oldLogin, Users u)
	{
		try
		{
			cnx = DAOConnection.getConnection();
		    PreparedStatement ps = cnx.prepareStatement(""
		    		+ "update Users set "
		    		+ "login=?, password=?, role=? "
		    		+ "where login=?");
		    ps.setString(1, u.getLogin());
		    ps.setString(2, u.getPassword());
		    ps.setString(3, u.getRole());
		    ps.setString(4, oldLogin);

		    int i = ps.executeUpdate();
		    ps.close();
		    DAOConnection.close();
		    if(i>0)
			    return true;
		    return false;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}

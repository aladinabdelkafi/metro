package metro.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DAOConnection 
{
	private static Connection cnx;
	
	
	public static Connection getConnection()
	{
		try{
			Class.forName ("oracle.jdbc.OracleDriver");
		}
		catch(Exception e)
		{
			e.printStackTrace ();
		}
		
		try
		{
			if(cnx==null || cnx.isClosed()) {
			String url= "jdbc:oracle:thin:@localhost:1521:xe";
		    String user="firas";
		    String pass="firas";
		    cnx = DriverManager.getConnection(url,user,pass);
			}
			System.out.println("c bon");
			}
		catch(Exception e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Erreur");
			alert.setContentText("Erreur de Connection à la Base de Donnée");
			alert.showAndWait();
		}
		return cnx;
	}
	
	
	public static void close()
	{
		try
		{
			if(cnx!=null && !cnx.isClosed())
			{
				cnx.close();
				System.out.println("connection is closed: "+cnx.isClosed());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}

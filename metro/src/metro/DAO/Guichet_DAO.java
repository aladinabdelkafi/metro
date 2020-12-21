package metro.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Guichet;


public class Guichet_DAO {
	public static  Connect conn;
	private Connection cnx;
	Station_DAO stat= new Station_DAO();
	
	public Guichet_DAO() {
		cnx=(Connection) Connect.getConnection();
	}

	
	
	public boolean add_Guichet_Manuel(int num_stat){
		int se=0;
			se=1;
				String req="insert into Guichet (type,num_station) values"+ "('Manuel','"+num_stat+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert guichet Manuel done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());	
				}return false;
			}

	public boolean add_Guichet_Auto(int num_stat){
		int se=0;
			se=1;
				String req="insert into Guichet (type,num_station) values"+ "('Automatique','"+num_stat+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert guichet Manuel done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());	
				}return false;
			}
	
	public Guichet findGuichet(int x)
	{
		Guichet r=new Guichet() ;
		
		String req="select * from Guichet where Num_guichet='"+x+"' ";
		try {
			Statement st = (Statement) cnx.createStatement();
			ResultSet rs =st.executeQuery(req);
			while(rs.next()){
				
						
						r.setNum_guichet(rs.getInt(1));
						r.setType(rs.getString(2));
						r.setStation(stat.findStation(rs.getInt(3)));
						
			}
			
		} catch (SQLException e) {
		System.out.println("Error  in findZonne(x) "+e.getMessage()); 
		}return r;
		
	}

	public ObservableList<Guichet>  findGuichet_station(int x)
	{
	
		ObservableList<Guichet> r = FXCollections.observableArrayList();
		String req="select * from Guichet where Num_guichet='"+x+"' ";
		try {
			Statement st = (Statement) cnx.createStatement();
			ResultSet rs =st.executeQuery(req);
			while(rs.next()){
				
				r.add(new Guichet(rs.getInt(1)));
						
						
			}
			
		} catch (SQLException e) {
		System.out.println("Error  in findZonne(x) "+e.getMessage()); 
		}return r;
		
	}
	
	
}

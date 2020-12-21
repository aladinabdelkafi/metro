package  metro.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Station;

public class Station_DAO {
	//public static  Connect conn;
	private Connection cnx;
	
	public Station_DAO() {
		cnx=(Connection) Connect.getConnection();
	}

	
	public boolean add_Station(Station s  ){
		int se=0;

			se=1;
				String req="insert into Station values"+ "('','"+s.getNom_station()+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert Zonne done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());
					
				}return false;
			}

		public ObservableList<Station> findAll_Station()
		{
			ObservableList<Station> r = FXCollections.observableArrayList();
			
			String req="select * from Station";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					r.add(new Station(rs.getInt(1),rs.getString(2)));
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Zonne) "+e.getMessage()); 
			}return r;
			
		}

			
		


		public Station findStation(int x)
		{
			Station r=new Station() ;
			
			String req="select * from Station where num_station='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
							
							r.setNum_station(rs.getInt(1));
							r.setNom_station(rs.getString(2));
							
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findZonne(x) "+e.getMessage()); 
			}return r;
			
		}




		public boolean Delete_Station(int x){
			String reqP="Delete  from  Station where num_station=? ";
			try {
				PreparedStatement pst=(PreparedStatement) cnx.prepareStatement(reqP);
				pst.setInt(1,x);
				
				int nl=pst.executeUpdate();
				if(nl!=0){
					System.out.println("Delete Succefly (Zonne)");
					return true;
				}
			} catch (SQLException e) {
		System.out.println("Error in Delete (Zonne)"+e.getMessage());	
		}return false;
			
		}


		public boolean update_Station (Station s){
		String req= "update  Zonne set nom_station='"+s.getNom_station()+"' where num_station='"+s.getNum_station()+"'"; 

		try {
				Statement st=(Statement) cnx.createStatement();
				int nl= st.executeUpdate(req);
				if(nl!=0)
				{
				System.out.println("Update with  Succefly");
				return true;
				}
				 return false;
			} catch (SQLException e) {
		System.out.println("Error in Update "+e.getMessage());		
		}return false;
		}


}

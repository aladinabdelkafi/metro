package  metro.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Tourniquet;
import metro.model.Tourniquet_Entree;
import metro.model.Tourniquet_Sortie;

public class Tourniquet_DAO {
	private Connection cnx;
	private LigneDAO lDAO=new LigneDAO();
	private Zonne_DAO zDAO= new Zonne_DAO();
	private Station_DAO sDAO = new Station_DAO();
	
	private Tourniquet_Entree r1;
	public Tourniquet_DAO() {
		cnx=(Connection) Connect.getConnection();
	}
	
	public boolean add_Tourniquet(int Num_Station){
		int se=0;
		
			se=1;
		
				String req="insert into Tourniquet (num_station) values ('"+Num_Station+"')";
				
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert Tourniquet done ");
				
					return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert "+e.getMessage());
					
				}return false;
			}
	public Tourniquet findTournique(int x)
	{
		
		Tourniquet r=new Tourniquet() ;
		
		String req="select * from tourniquet where Num_tourniquet='"+x+"' ";
		try {
			Statement st = (Statement) cnx.createStatement();
			ResultSet rs =st.executeQuery(req);
			while(rs.next()){
				
				
						r.setNum_tourniquet(rs.getInt(1));
						r.setStation(sDAO.findStation(rs.getInt(2)));
						
						
			}
			
		} catch (SQLException e) {
		System.out.println("Error  in findZonne(x) "+e.getMessage()); 
		}return r;
		
	}

		public ObservableList<Tourniquet> findAll_Tourniquet()
		{
			ObservableList<Tourniquet> r = FXCollections.observableArrayList();
			
			String req="select * from Tourniquet";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					;
					r.add(new Tourniquet(rs.getInt(1),sDAO.findStation(rs.getInt(2))));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Tourniquet) "+e.getMessage()); 
			}return r;
			
		}
		public boolean add_Tourniquet_Entree(int Num_tourniquet){
			int se=0;
			
				se=1;
			
					String req="insert into Tourniquet_Entree (Num_tourniquet) values"+ "('"+Num_tourniquet+"')";
					
					try {
						Statement st = (Statement) cnx.createStatement();
						int nl=st.executeUpdate(req);
						if(nl!=0){System.out.println("Insert Tourniquet done ");
					
						return true;}
					} catch (SQLException e) {
					System.out.println("Error in insert "+e.getMessage());
						
					}return false;
				}
		public boolean add_Tourniquet_Sortie(int Num_tourniquet){
			int se=0;
			
				se=1;
			
					String req="insert into Tourniquet_Sortie (Num_tourniquet) values"+ "('"+Num_tourniquet+"')";
					
					try {
						Statement st = (Statement) cnx.createStatement();
						int nl=st.executeUpdate(req);
						if(nl!=0){System.out.println("Insert Tourniquet done ");
					
						return true;}
					} catch (SQLException e) {
					System.out.println("Error in insert "+e.getMessage());
						
					}return false;
				}
		public Tourniquet_Sortie findTourniquet_Sortie(int x)
		{
			
			 Tourniquet_Sortie r = new Tourniquet_Sortie(0, null);
			
			String req="select * from Tourniquet_Sortie where id_Tourniquet_Sortie='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					Tourniquet t=  findTournique(rs.getInt(2));
							
							r.setId_Tourniquet_Sortie(rs.getInt(1));
							r.setNum_tourniquet(t.getNum_tourniquet());
						
							r.setStation(t.getStation());
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findZonne(x) "+e.getMessage()); 
			}return r;
			
		}

		
		
		public Tourniquet_Entree findTourniquet_Entree(int x)
		{
			
			r1 = null;
			
			String req="select * from tourniquet_entree where id_Tourniquet_entree='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					Tourniquet t=  findTournique(rs.getInt(2));
							
							r1.setId_Tourniquet_Entree(rs.getInt(1));
							r1.setNum_tourniquet(t.getNum_tourniquet());
							r1.setStation(t.getStation());;
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findZonne(x) "+e.getMessage()); 
			}return r1;
			
		}


}

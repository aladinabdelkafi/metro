package  metro.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Arret_String;
import metro.model.Station;

public class Arret_DAO {

	public static int num=1;
	private Connection cnx;
	private LigneDAO lDAO=new LigneDAO();
	private Zonne_DAO zDAO= new Zonne_DAO();
	private Station_DAO sDAO = new Station_DAO();
	public Arret_DAO() {
		cnx=(Connection) Connect.getConnection();
	}
	
	
	
	public int max_Arret(int l){
		 int r=0;
			String req="select COUNT(Num_Arret) from Arret where Num_Ligne='"+l+"'";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					r=rs.getInt(1);
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in count(Arret) "+e.getMessage()); 
			}return r+1;
		}
	
	public boolean add_Arret(int Num_Ligne,int Num_Zonne,int Num_Station){
		int se=0;
		String concat=Integer.toString(max_Arret(Num_Ligne))+"/"+Integer.toString(Num_Ligne);
		System.out.println(concat);
			se=1;
			Station stat= sDAO.findStation(Num_Station); 
				String req="insert into Arret values"+ "('"+concat+"','"+stat.getNom_station()+"','"+Num_Ligne+"','"+Num_Zonne+"','"+Num_Station+"')";
				
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert Arret done ");
					num++;
					return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert "+e.getMessage());
					
				}return false;
			}

		public ObservableList<Arret_String> findAll_Arrets()
		{
			//ObservableList<Arret> r = FXCollections.observableArrayList();
			ObservableList<Arret_String> rr = FXCollections.observableArrayList();
			
			String req="select * from Arret";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					
					rr.add(new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Arret) "+e.getMessage()); 
			}return rr;
			
		}

			
		public ObservableList<Arret_String> findArretsOfLigne(int l)
		{
			ObservableList<Arret_String> rr = FXCollections.observableArrayList();
			String req="select * from Arret where Num_Ligne='"+l+"'";
	
			
			
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					rr.add(new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findArretsOfLigne(Ligne) "+e.getMessage()); 
			}return rr;
			
		}	


		public Arret_String findArret(String x)
		{
			Arret_String r=new Arret_String() ;
			
			String req="select * from Arret where Num_Arret='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					r= new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station());
					
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findArret(x) "+e.getMessage()); 
			}return r;
			
		}

		public ObservableList<Arret_String> find_Arret_Zonne(int z)
		{
			ObservableList<Arret_String> r = FXCollections.observableArrayList();
			
			String req="select * from Arret where Num_zonne='"+z+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					
					r.add(new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station()));
					
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Arret) "+e.getMessage()); 
			}return r;
			
		}

		public ObservableList<Arret_String> find_Arret_Zonne_Ligne(int z ,int l)
		{
			ObservableList<Arret_String> r = FXCollections.observableArrayList();
			
			String req="select * from Arret where Num_zonne='"+z+"' and Num_Ligne='"+l+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					
					r.add(new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station()));
					
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Arret) "+e.getMessage()); 
			}return r;
			
		}
		
		public boolean Delete_Arret(int x){
			String reqP="Delete  from  Arret where Num_Arret=? ";
			try {
				PreparedStatement pst=(PreparedStatement) cnx.prepareStatement(reqP);
				pst.setInt(1,x);
				
				int nl=pst.executeUpdate();
				if(nl!=0){
					System.out.println("Delete Succefly (Arret)");
					return true;
				}
			} catch (SQLException e) {
		System.out.println("Error in Delete (Arret)"+e.getMessage());	
		}return false;
			
		}


		public boolean update_Arret (int num_Arret,String Nom_arret,int Num_Ligne,int Num_Zonne,int Num_Station){
		String req= "update  Arret set Nom_arret='"+Nom_arret+"',Num_Ligne='"+Num_Ligne+"',Num_zonne='"+Num_Zonne+"',num_station='"+Num_Station+"' where Num_Arret='"+num_Arret+"'"; 

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

		//station (donnééé) =====> les arret téb3in station héki
		public ObservableList<Arret_String> find_Arret_Station(int z)
		{
			ObservableList<Arret_String> r = FXCollections.observableArrayList();
			
			String req="select * from Arret where num_station='"+z+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					
					r.add(new Arret_String(rs.getString(1),rs.getString(2),lDAO.findLigne(rs.getInt(3)).getNom_ligne(),zDAO.findZonne(rs.getInt(4)).getNom_zone(),sDAO.findStation(rs.getInt(5)).getNom_station()));
					
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Arret) "+e.getMessage()); 
			}return r;
			
		}

		
		
}

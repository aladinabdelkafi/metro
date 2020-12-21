package  metro.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Count;
import metro.model.Guichet;
import metro.model.Ticket_String;
import metro.model.Zonne;

public class Ticket_DAO {
	public static  Connect conn;
	private Connection cnx;
	private Zonne_DAO zD = new Zonne_DAO();
	private Type_DAO sD= new  Type_DAO();
	private Guichet_DAO dui_DAO = new Guichet_DAO();
	private Tourniquet_DAO trq= new Tourniquet_DAO();
	public Ticket_DAO() {
		cnx=(Connection) Connect.getConnection();
	}
	
	public boolean add_Ticket(int Num_guichet,int Num_zonne, int Num_type ){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
			int se=1;
				String req="insert into Ticket (date_heure_achat,Num_guichet,Num_zonne,Num_type) values"+ "('"+dateFormat.format(date)+"','"+Num_guichet+"','"+Num_zonne+"','"+Num_type+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert Zonne done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());
					
				}return false;
			}

		public ObservableList<Ticket_String> findAll_Ticket()
		{
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			
			String req="select * from Ticket";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
				
r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),rs.getTimestamp(3),rs.getTimestamp(4),dui_DAO.findGuichet(rs.getInt(5)).getStation().getNom_station(),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type(),trq.findTourniquet_Sortie(rs.getInt(9)).getStation().getNom_station()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}

		
		public ObservableList<Ticket_String> findAll_Ticket_ByGuichet(int guicht)
		{
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			
			String req="select * from Ticket where Num_guichet='"+guicht+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
				
r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),rs.getTimestamp(3),rs.getTimestamp(4),dui_DAO.findGuichet(rs.getInt(5)).getStation().getNom_station(),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type(),trq.findTourniquet_Sortie(rs.getInt(9)).getStation().getNom_station()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}

		
		
		public boolean Entree_Ticket (int num_trk_ent,int num_ticket){

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String req= "update  Ticket set date_heure_entre='"+dateFormat.format(date)+"',id_Tourniquet_Entree='"+num_trk_ent+"' where Num='"+num_ticket+"'"; 

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

		
		public boolean Sortie_Ticket (int num_trk_srt,int num_ticket){

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String req= "update  Ticket set 	date_heure_sortie='"+dateFormat.format(date)+"',id_Tourniquet_Sortie='"+num_trk_srt+"' where Num='"+num_ticket+"'"; 

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

		

		
		public ObservableList<Ticket_String> findAll_Ticket_Zone(int num_zone)
		{
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			
			String req="select * from Ticket where Num_zonne='"+num_zone+"'";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					
					r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type()));
									}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}
		
		
		
		
		
		
		public ObservableList<Ticket_String> findAll_Ticket_Station(int num_stat)
		{
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			ObservableList<Guichet> guich= dui_DAO.findGuichet_station(num_stat);
			for (int i=0;i<guich.size();i++){
			String req="select * from Ticket where Num_guichet='"+guich.get(i).getNum_guichet()+"'";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
										
					r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type()));
									}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}
			}
			return r;
		}
		public ObservableList<Ticket_String> findAll_Ticket_year(int  y)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			dateFormat.format(date);
			ObservableList<Ticket_String> rr = FXCollections.observableArrayList();
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			r=findAll_Ticket();
			for(int i=0;i<r.size();i++){
				if (r.get(i).getDate_heure_achat().getYear()==y)
					rr.add(r.get(i));	
			}
			return rr;
		}
		
		public ObservableList<Ticket_String> findAll_Ticket_month(int  m)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
		 int y=Integer.parseInt( dateFormat.format(date).substring(0, 4));
			ObservableList<Ticket_String> rr = FXCollections.observableArrayList();
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			r=findAll_Ticket();
			for(int i=0;i<r.size();i++){
				String s=r.get(i).getDate_heure_achat().toString();
				
				int ann=Integer.parseInt( s.substring(0, 4));
				int mm=Integer.parseInt( s.substring(5, 7));
				
				if (ann==y && mm==m )
					rr.add(r.get(i));	
			}
			return rr;
		}
		
		public ObservableList<Ticket_String> findAll_Ticket_day(int  j)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
		 int y=Integer.parseInt( dateFormat.format(date).substring(0, 4));
		 int m=Integer.parseInt( dateFormat.format(date).substring(5, 7));
		
			ObservableList<Ticket_String> rr = FXCollections.observableArrayList();
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			r=findAll_Ticket();
			for(int i=0;i<r.size();i++){
				String s=r.get(i).getDate_heure_achat().toString();
				
				int ann=Integer.parseInt( s.substring(0, 4));
				int mm=Integer.parseInt( s.substring(5, 7));
				int jj=Integer.parseInt( s.substring(8, 10));
				
				if (ann==y && mm==m && jj==j)
					rr.add(r.get(i));	
			}
			return rr;
		}
		
		
		
		public ObservableList<Ticket_String> findAll_Ticket_param(int guicht)
		{
			ObservableList<Ticket_String> r = FXCollections.observableArrayList();
			
			String req="select * from Ticket where Num_guichet='"+guicht+"'  ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
				
r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}
		
		
		
		public ObservableList<Count> Stat_Ticket_Zone()
		{
			ObservableList<Count> r = FXCollections.observableArrayList();
			
			
			String req="select Num_zonne , count(*) from Ticket GROUP BY Num_zonne ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				
				while(rs.next()){
					r.add(new Count(zD.findZonne(rs.getInt(1)).getNom_zone(),rs.getInt(2)) );
					}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}
		public ArrayList<Count> Stat_Ticket_Zone_ArrayList()
		{
			ArrayList<Count> r = new ArrayList<>();
			
			
			String req="select Num_zonne , count(*) from Ticket GROUP BY Num_zonne ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				
				while(rs.next()){
					r.add(new Count(zD.findZonne(rs.getInt(1)).getNom_zone(),rs.getInt(2)) );
					}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}
		
		public ArrayList<Ticket_String> findAll_Ticket_arrayList()
		{
			ArrayList<Ticket_String> r = new ArrayList<Ticket_String>();
			
			String req="select * from Ticket";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
				
					r.add(new Ticket_String(rs.getInt(1),rs.getTimestamp(2),zD.findZonne(rs.getInt(6)).getNom_zone(),sD.findType_Ticket(rs.getInt(7)).getLib_type()));
				
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}

		public ArrayList<Ticket_String> findAll_Ticket_year_arrayList(int  y)
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			dateFormat.format(date);
			ArrayList<Ticket_String> rr = new ArrayList<Ticket_String>();
			ArrayList<Ticket_String> r = new ArrayList<Ticket_String>();
			r=findAll_Ticket_arrayList();
			for(int i=0;i<r.size();i++){
				String yy=r.get(i).getDate_heure_achat().toString();
				int ann=Integer.parseInt( yy.substring(0, 4));
				
				if (ann==y)
					rr.add(r.get(i));	
			}
			return rr;
		}

		public float prix(int z1,int z2,int type){
			int max=z1;
			int min=z2;
			float sum=0;
			ObservableList<Zonne> liste_zo=zD.findAll_Zonne();
			if(z2>z1)
			{
				max=z2;
				min=z1;
			}
			
			for(int j=min;j<=max;j++){
				
				
			sum+=liste_zo.get(j-1).getTarif();			}
			if(type ==2)
				sum=(float) (sum*1.5);
			return sum;
		}
		
		
		
		public ArrayList<Count> Stat_Ticket_month_array()
		{
			ArrayList<Count> r = new ArrayList<Count>();
			
			
			String req="SELECT  MONTH(date_heure_achat),count(*)  from ticket where YEAR(date_heure_achat)=year(SYSDATE()) group by MONTH(date_heure_achat)";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				
				while(rs.next()){
					r.add(new Count(rs.getString(1),rs.getInt(2) ));
					}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}return r;
			
		}
		
		
		public int find_Zonne_of_station(int num_stat)
		{
			
			
			int r=0;
			String req="SELECT distinct  num_zonne FROM arret WHERE num_station='"+num_stat+"'";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
							r=rs.getInt(1);			
							}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Ticket) "+e.getMessage()); 
			}
			
			return r;
		}

		
		
		
}

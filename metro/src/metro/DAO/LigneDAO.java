package metro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Ligne;

public class LigneDAO {
	public static Connection cnx;

	public LigneDAO() {
		cnx=Connect.getConnection();
	}

	

public int max_Ligne(){
 int r=0;
	String req="select MAX(Num_Ligne) from Ligne";
	try {
		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			r=rs.getInt(1);
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in count(Ligne) "+e.getMessage()); 
	}return r;
}

public boolean add_ligne(Ligne l ){
int se=1;
String dep=l.getDepart();
String term =l.getTerminus();
String nom=dep+"/"+term;
String req="insert into Ligne (Nom_ligne,Depart,Terminus) values ('"+nom+"','"+l.getDepart()+"','"+l.getTerminus()+"')";
		System.out.println(req);
 
		try {
			Statement st = (Statement) cnx.createStatement();
			int nl=st.executeUpdate(req);
			if(nl!=0){System.out.println("Insert LINGE done ");return true;}
		} catch (SQLException e) {
		System.out.println("Error in insert"+e.getMessage());
			
		}return false;
	}

public ObservableList<Ligne> findAll_lignes()
{
	ObservableList<Ligne> r = FXCollections.observableArrayList();
	
	String req="select * from Ligne";
	try {

		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			
			r.add(new Ligne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in findall(Ligne) "+e.getMessage()); 
	}return r;
	
}


public ObservableList<Ligne> findAll_lignes_not_pass (String Nom_station)
{
	ObservableList<Ligne> r = FXCollections.observableArrayList();
	
	String req="select * from Ligne l Arret a where l.Num_Ligne=a.Num_Ligne and a.Nom_arret !='"+Nom_station+"'";
	try {
		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			
			r.add(new Ligne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in findall(Ligne) "+e.getMessage()); 
	}return r;
	
}
public ObservableList<Ligne> findMax_Arret_of_Ligne ()
{//dbcjhdsvjhcdvjhds
	ObservableList<Ligne> r = FXCollections.observableArrayList();
	
	String req="select * from Ligne l Arret a where l.Num_Ligne=a.Num_Ligne and a.Nom_arret !=''";
	try {
		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			
			r.add(new Ligne(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in findall(Ligne) "+e.getMessage()); 
	}return r;
	
}
/*
public ObservableList<Arret> findArretsOfLigne(Ligne l)
{
	ObservableList<Arret> r = FXCollections.observableArrayList();
	String req="select * from Arret where Num_Ligne='"+l.getNum_Ligne()+"'";
	Zonne_DAO zDAO= new Zonne_DAO();
	
	try {
		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			
			r.add(new Arret(rs.getInt(1),rs.getString(2),findLigne(l.getNum_Ligne()),zD.findZonne(rs.getInt(3)),sD.findStation(rs.getInt(4))));
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in findArretsOfLigne(Ligne) "+e.getMessage()); 
	}return r;
	
}

*/
public Ligne findLigne(int x)
{
	Ligne r=new Ligne() ;
	
	String req="select * from Ligne where Num_Ligne='"+x+"' ";
	try {
		Statement st = (Statement) cnx.createStatement();
		ResultSet rs =st.executeQuery(req);
		while(rs.next()){
			
					
					r.setNum_Ligne(rs.getInt(1));
					r.setNom_ligne(rs.getString(2));

					r.setDepart(rs.getString(3));
					r.setTerminus(rs.getString(4));
					
		}
		
	} catch (SQLException e) {
	System.out.println("Error  in findligne(Ligne) "+e.getMessage()); 
	}return r;
	
}




public boolean Delete_ligne(int x){
	String reqP="Delete  from  Ligne where Num_Ligne=? ";
	try {
		PreparedStatement pst=(PreparedStatement) cnx.prepareStatement(reqP);
		pst.setInt(1,x);
		
		int nl=pst.executeUpdate();
		if(nl!=0){
			System.out.println("Delete Succefly (Ligne)");
			return true;
		}
	} catch (SQLException e) {
System.out.println("Error in Delete (Ligne)"+e.getMessage());	
}return false;
	
}


public boolean update_ligne (Ligne l ){
	String dep=l.getDepart();
	String term =l.getTerminus();
	String nom=dep+"/"+term;
	String req= "update  Ligne set Nom_ligne='"+nom+"', Depart='"+l.getDepart()+"',Terminus='"+l.getTerminus()+"' where Num_Ligne='"+l.getNum_Ligne()+"'"; 
System.out.println(req);
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



package  metro.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.*;

public class Zonne_DAO {
	public static Connection cnx;
	
	public Zonne_DAO() {
		cnx=(Connection) Connect.getConnection();
	}

	public int max_Zonne(){
		 int r=0;
			String req="select MAX(Num_Zonne) from Zonne";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					r=rs.getInt(1);
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in count(Zonne) "+e.getMessage()); 
			}return r;
		}
	
	public boolean add_Zonne(Zonne z  ){
		int se=0;

			se=1;
				String req="insert into Zonne values"+ "('','"+z.getNom_zone()+"','"+z.getTarif()+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert Zonne done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());
					
				}return false;
			}

		public ObservableList<Zonne> findAll_Zonne()
		{
			ObservableList<Zonne> r = FXCollections.observableArrayList();
			
			String req="select * from Zonne";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					r.add(new Zonne(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Zonne) "+e.getMessage()); 
			}return r;
			
		}

			
		


		public Zonne findZonne(int x)
		{
			Zonne r=new Zonne() ;
			
			String req="select * from Zonne where Num_Zonne='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
							
							r.setNum_zonne(rs.getInt(1));
							r.setNom_zone(rs.getString(2));
							r.setTarif(rs.getFloat(3));
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findZonne(x) "+e.getMessage()); 
			}return r;
			
		}


		


		public boolean Delete_Zonne(int x){
			String reqP="Delete  from  Zonne where Num_Zonne=? ";
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


		public boolean update_Zonne (Zonne z){
		String req= "update  Zonne set Nom_Zone='"+z.getNom_zone()+"',tarif='"+z.getTarif()+"' where Num_zonne='"+z.getNum_zonne()+"'"; 

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

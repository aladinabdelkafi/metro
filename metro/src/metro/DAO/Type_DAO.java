package  metro.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metro.model.Type_Ticket;

public class Type_DAO {

	public static  Connect conn;
	private Connection cnx;
	
	public Type_DAO() {
		cnx=(Connection) Connect.getConnection();
	}
	
	
	
	public boolean add_type_ticket( String type  ){
		int se=0;

			se=1;
				String req="insert into type_ticket (type) values"+ "('"+type+"')";
				try {
					Statement st = (Statement) cnx.createStatement();
					int nl=st.executeUpdate(req);
					if(nl!=0){System.out.println("Insert type_ticket done ");return true;}
				} catch (SQLException e) {
				System.out.println("Error in insert"+e.getMessage());
					
				}return false;
			}

		public ObservableList<Type_Ticket> findAll_type_ticket()
		{
			ObservableList<Type_Ticket> r = FXCollections.observableArrayList();
			
			String req="select * from type_ticket";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
					r.add(new Type_Ticket(rs.getInt(1),rs.getString(2)));
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findall(Zonne) "+e.getMessage()); 
			}return r;
			
		}

			
		


		public Type_Ticket findType_Ticket(int x)
		{
			Type_Ticket r=new Type_Ticket() ;
			
			String req="select * from type_ticket where Num_type='"+x+"' ";
			try {
				Statement st = (Statement) cnx.createStatement();
				ResultSet rs =st.executeQuery(req);
				while(rs.next()){
					
							
							r.setNum_type(rs.getInt(1));
							r.setLib_type(rs.getString(2));
							
							
				}
				
			} catch (SQLException e) {
			System.out.println("Error  in findNum_type(x) "+e.getMessage()); 
			}return r;
			
		}


		


		public boolean Delete_Type_Ticket(int x){
			String reqP="Delete  from  type_ticket where Num_type=? ";
			try {
				PreparedStatement pst=(PreparedStatement) cnx.prepareStatement(reqP);
				pst.setInt(1,x);
				
				int nl=pst.executeUpdate();
				if(nl!=0){
					System.out.println("Delete Succefly (Num_type)");
					return true;
				}
			} catch (SQLException e) {
		System.out.println("Error in Delete (Num_type)"+e.getMessage());	
		}return false;
			
		}


		


}

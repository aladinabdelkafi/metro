package metro.DAO;

import javafx.collections.ObservableList;
import metro.model.Ligne;

public class test {

	public static void main(String[] args) {
LigneDAO d = new LigneDAO()
;

UsersDAO u = new UsersDAO();
System.out.println(u.find("1"));


ObservableList<Ligne>l = d.findAll_lignes();

for (Ligne c :l)
	System.out.println(c.getNom_ligne());
	
	}
}

package metro.model;

import java.util.ArrayList;

public class Type_Ticket {
private int num_type;
private String lib_type;
private ArrayList<Ticket> Liste_Ticket = new ArrayList<Ticket>();
public Type_Ticket() {}

public Type_Ticket(int num_type, String lib_type) {
	this.num_type = num_type;
	this.lib_type = lib_type;
}
public int getNum_type() {
	return num_type;
}
public void setNum_type(int num_type) {
	this.num_type = num_type;
}
public String getLib_type() {
	return lib_type;
}
public void setLib_type(String lib_type) {
	this.lib_type = lib_type;
}

public ArrayList<Ticket> getListe_Ticket() {
	return Liste_Ticket;
}

public void setListe_Ticket(ArrayList<Ticket> liste_Ticket) {
	Liste_Ticket = liste_Ticket;
}

}

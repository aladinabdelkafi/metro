package metro.model;

import java.util.ArrayList;

public class Guichet {
private int Num_guichet;
private String type;
private Station station;
private ArrayList<Ticket> Liste_Ticket_guichet = new ArrayList<Ticket>();

public Guichet(int num_guichet ,Station station,String type) {
	this.Num_guichet=num_guichet;
	this.station=station;
	this.type=type;
}
public Guichet(int num_guichet) {
	this.Num_guichet=num_guichet;
}
public Guichet() {
	
}
public int getNum_guichet() {
	return Num_guichet;
}
public void setNum_guichet(int num_guichet) {
	Num_guichet = num_guichet;
}
public Station getStation() {
	return station;
}
public void setStation(Station station) {
	this.station = station;
}
public ArrayList<Ticket> getListe_Ticket_guichet() {
	return Liste_Ticket_guichet;
}
public void setListe_Ticket_guichet(ArrayList<Ticket> liste_Ticket_guichet) {
	Liste_Ticket_guichet = liste_Ticket_guichet;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}

package metro.model;

import java.util.ArrayList;

public class Station {
private int num_station;
private String nom_station;
private ArrayList<Arret> ListArret_Station= new ArrayList<Arret>();
//private ArrayList<Guichet> List_Guichet= new ArrayList<Guichet>();
//private ArrayList<Tourniquet> List_Tourniquet= new ArrayList<Tourniquet>();
public Station() {
	
}

public Station(int num_station, String nom_station) {
	this.num_station = num_station;
	this.nom_station = nom_station;
}
public Station(int num_station, String nom_station, ArrayList<Arret> listArret_Station) {

	this.num_station = num_station;
	this.nom_station = nom_station;
	ListArret_Station = listArret_Station;
}
public String getNom_station() {
	return nom_station;
}
public void setNom_station(String nom_station) {
	this.nom_station = nom_station;
}
public int getNum_station() {
	return num_station;
}
public void setNum_station(int num_station) {
	this.num_station = num_station;
}
public ArrayList<Arret> getListArret_Station() {
	return ListArret_Station;
}
public void setListArret_Station(ArrayList<Arret> listArret_Station) {
	ListArret_Station = listArret_Station;
}

@Override
public String toString() {
	return "Numéro Station: " + num_station + "| Nom Station: " + nom_station ;
}


/*
public ArrayList<Guichet> getList_Guichet() {
	return List_Guichet;
}
public void setList_Guichet(ArrayList<Guichet> list_Guichet) {
	List_Guichet = list_Guichet;
}
public ArrayList<Tourniquet> getList_Tourniquet() {
	return List_Tourniquet;
}
public void setList_Tourniquet(ArrayList<Tourniquet> list_Tourniquet) {
	List_Tourniquet = list_Tourniquet;
}
*/
}

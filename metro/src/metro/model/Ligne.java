package metro.model;


public class Ligne {
private  int Num_Ligne;
private String Depart;
private String Terminus;
private String Nom_ligne;
public Ligne(){}
public Ligne( String nom,String depart, String terminus ) {
	Depart = depart;
	Terminus = terminus;
	this.Nom_ligne=nom;
}
public Ligne(int num,String Nom_ligne, String depart, String terminus ) {
	Num_Ligne = num;
	Depart = depart;
	Terminus = terminus;
	this.Nom_ligne=Nom_ligne;
}
public Ligne(int num, String depart, String terminus ) {
	Num_Ligne = num;
	Depart = depart;
	Terminus = terminus;
	//this.Nom_ligne=Nom_ligne;
}


public String getNom_ligne() {
	return Nom_ligne;
}

public String getDepart() {
	return Depart;
}
public void setDepart(String depart) {
	Depart = depart;
}
public String getTerminus() {
	return Terminus;
}
public void setTerminus(String terminus) {
	Terminus = terminus;
}
public  int getNum_Ligne() {
	return Num_Ligne;
}/*
public ArrayList<Arret> getListArret() {
	return ListArret;
}
public void setListArret(ArrayList<Arret> listArret) {
	ListArret = listArret;
}
public ArrayList<Metro> getListMetro() {
	return ListMetro;
}
public void setListMetro(ArrayList<Metro> listMetro) {
	ListMetro = listMetro;
}
*/
public void setNum_Ligne(int num_Ligne) {
	Num_Ligne = num_Ligne;
}
public void setNom_ligne(String nom_ligne) {
	Nom_ligne = nom_ligne;
}
@Override
public String toString() {
	return "Numero Ligne: "+Num_Ligne+ "| Nom Ligne: "+ Nom_ligne;
}




}

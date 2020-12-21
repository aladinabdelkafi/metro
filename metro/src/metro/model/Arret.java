package metro.model;

import java.util.ArrayList;

public class Arret {
	
	private  String Num_arret;
	private  String Nom_arret;
	private Ligne ligne;
	private Zonne zonne;
	private Station station;
	private ArrayList<Arret> ListCorrespondances= new ArrayList<Arret>();
	public Arret(){}
	
	public Arret(String num_arret){
		
		Num_arret=num_arret;}
	public Arret(Ligne ligne,Zonne zonne,Station station) {
		this.ligne = ligne;
		 this.zonne=zonne;
		 this.station=station;
		 this.Nom_arret="";
	}
	public Arret(String num_arret,String Nom_arret,  Ligne l ,Zonne z,Station station) {
		Num_arret=num_arret;
		this.Nom_arret=Nom_arret;
		ligne=l;
		zonne=z;
		this.station=station;
	}
	
	
	
	public Ligne getLigne() {
		return ligne;
	}
	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}
	public  String getNum_arret() {
		return Num_arret;
	}
	public Zonne getZonne() {
		return zonne;
	}
	public void setZonne(Zonne zonne) {
		this.zonne = zonne;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public ArrayList<Arret> getListCorrespondances() {
		return ListCorrespondances;
	}

	public void setListCorrespondances(ArrayList<Arret> listCorrespondances) {
		ListCorrespondances = listCorrespondances;
	}

	public String getNom_arret() {
		return Nom_arret;
	}

	public void setNom_arret(String nom_arret) {
		Nom_arret = nom_arret;
	}

	@Override
	public String toString() {
		return "Arret [Num_arret=" + Num_arret + ", Nom_arret=" + Nom_arret + ", ligne=" + ligne.getNom_ligne() + ", zonne=" + zonne
				+ ", station=" + station + ", ListCorrespondances=" + ListCorrespondances + "]";
	}
	
	

}

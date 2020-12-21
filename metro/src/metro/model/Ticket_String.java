package  metro.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Ticket_String {
	private int Num;
	private Timestamp date_heure_achat;
	private Timestamp date_heure_entre;
	private Timestamp date_heure_sortie;
	private String Nom_Station_Entree;//jeya mel guichet
	private String Nom_zonne;
	private String Nom_type;
	
	private String Nom_Station_Sortie;//jeya mel tourniquet de sortie
	
	
	public Ticket_String() {
		
	}
	public Ticket_String(int num, Timestamp date_heure_achat,  String nom_zonne, String nom_type) {
		Num = num;
		this.date_heure_achat = date_heure_achat;
		Nom_zonne = nom_zonne;
		Nom_type = nom_type;
	}
	

	public Ticket_String(int num, Timestamp date_heure_achat, String nom_Station_Entree, String nom_zonne, String nom_type) {
		super();
		Num = num;
		this.date_heure_achat = date_heure_achat;
		Nom_Station_Entree = nom_Station_Entree;
		Nom_zonne = nom_zonne;
		Nom_type = nom_type;
	}

	public Ticket_String(int num, Timestamp date_heure_achat, Timestamp date_heure_entre, Timestamp date_heure_sortie,
			String nom_Station_Entree, String nom_zonne, String nom_type, String nom_Station_Sortie) {
		super();
		Num = num;
		this.date_heure_achat = date_heure_achat;
		this.date_heure_entre = date_heure_entre;
		this.date_heure_sortie = date_heure_sortie;
		Nom_Station_Entree = nom_Station_Entree;
		Nom_zonne = nom_zonne;
		Nom_type = nom_type;
		Nom_Station_Sortie = nom_Station_Sortie;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int num) {
		Num = num;
	}

	public Timestamp getDate_heure_achat() {
		return date_heure_achat;
	}

	public void setDate_heure_achat(Timestamp date_heure_achat) {
		this.date_heure_achat = date_heure_achat;
	}

	public Timestamp getDate_heure_entre() {
		return date_heure_entre;
	}

	public void setDate_heure_entre(Timestamp date_heure_entre) {
		this.date_heure_entre = date_heure_entre;
	}

	public Timestamp getDate_heure_sortie() {
		return date_heure_sortie;
	}

	public void setDate_heure_sortie(Timestamp date_heure_sortie) {
		this.date_heure_sortie = date_heure_sortie;
	}

	public String getNom_Station_Entree() {
		return Nom_Station_Entree;
	}

	public void setNom_Station_Entree(String nom_Station_Entree) {
		Nom_Station_Entree = nom_Station_Entree;
	}

	public String getNom_zonne() {
		return Nom_zonne;
	}

	public void setNom_zonne(String nom_zonne) {
		Nom_zonne = nom_zonne;
	}

	public String getNom_type() {
		return Nom_type;
	}

	public void setNom_type(String nom_type) {
		Nom_type = nom_type;
	}

	public String getNom_Station_Sortie() {
		return Nom_Station_Sortie;
	}

	public void setNom_Station_Sortie(String nom_Station_Sortie) {
		Nom_Station_Sortie = nom_Station_Sortie;
	}
	@Override
	public String toString() {
		return "Ticket_String [Num=" + Num + ", Nom_zonne=" + Nom_zonne + ", Nom_type=" + Nom_type + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package metro.model;


import java.util.ArrayList;

public class Zonne {
	private int Num_zonne;
	private String Nom_zone;
	private float tarif;
	private ArrayList<Arret> Liste_Arret = new ArrayList<Arret>();
	private ArrayList<Ticket> Liste_Ticket_Zonne = new ArrayList<Ticket>();
	public Zonne(String nom_zone, float tarif) {
		Nom_zone = nom_zone;
		this.tarif = tarif;
	}
	public Zonne(int Num_zonne, String nom_zone, float tarif) {
		this.Num_zonne=Num_zonne;
		Nom_zone = nom_zone;
		this.tarif = tarif;
	}
	public Zonne(){
	}
	public String getNom_zone() {
		return Nom_zone;
	}
	public void setNom_zone(String nom_zone) {
		Nom_zone = nom_zone;
	}
	public float getTarif() {
		return tarif;
	}
	public void setTarif(float tarif) {
		this.tarif = tarif;
	}
	public int getNum_zonne() {
		return Num_zonne;
	}
	public ArrayList<Arret> getListe_Arret() {
		return Liste_Arret;
	}
	public void setListe_Arret(ArrayList<Arret> liste_Arret) {
		Liste_Arret = liste_Arret;
	}
	public void setNum_zonne(int num_zonne) {
		Num_zonne = num_zonne;
	}
	public ArrayList<Ticket> getListe_Ticket_Zonne() {
		return Liste_Ticket_Zonne;
	}
	public void setListe_Ticket_Zonne(ArrayList<Ticket> liste_Ticket_Zonne) {
		Liste_Ticket_Zonne = liste_Ticket_Zonne;
	}
	@Override
	public String toString() {
		return "Numéro Zone: " + Num_zonne + "| Nom Zone: "+Nom_zone;
	}
	

}

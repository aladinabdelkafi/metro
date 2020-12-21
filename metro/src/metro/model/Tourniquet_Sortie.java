package  metro.model;


import java.util.ArrayList;

public class Tourniquet_Sortie extends Tourniquet {
	private int id_Tourniquet_Sortie;
	private ArrayList<Ticket> Liste_Ticket_tourniquet_Sortie = new ArrayList<Ticket>();

	public Tourniquet_Sortie() {
		super();
	}
	
	
	public Tourniquet_Sortie(int id_Tourniquet_Sortie,ArrayList<Ticket> liste_Ticket_tourniquet_Sortie) {
		
		super();
		this.id_Tourniquet_Sortie=id_Tourniquet_Sortie;
		Liste_Ticket_tourniquet_Sortie = liste_Ticket_tourniquet_Sortie;
	}

	public ArrayList<Ticket> getListe_Ticket_tourniquet_Sortie() {
		return Liste_Ticket_tourniquet_Sortie;
	}

	public void setListe_Ticket_tourniquet_Sortie(ArrayList<Ticket> liste_Ticket_tourniquet_Sortie) {
		Liste_Ticket_tourniquet_Sortie = liste_Ticket_tourniquet_Sortie;
	}


	public int getId_Tourniquet_Sortie() {
		return id_Tourniquet_Sortie;
	}


	public void setId_Tourniquet_Sortie(int id_Tourniquet_Sortie) {
		this.id_Tourniquet_Sortie = id_Tourniquet_Sortie;
	}

}

package  metro.model;


import java.util.ArrayList;

public class Tourniquet_Entree extends Tourniquet {
	private int id_Tourniquet_Entree;
	private ArrayList<Ticket> Liste_Ticket_tourniquet_Entree = new ArrayList<Ticket>();

	
	public Tourniquet_Entree() {
		super();
	}

	
	public Tourniquet_Entree( int id_Tourniquet_Entree,ArrayList<Ticket> liste_Ticket_tourniquet_Entree) {
		super();
		this.id_Tourniquet_Entree=id_Tourniquet_Entree;
		Liste_Ticket_tourniquet_Entree = liste_Ticket_tourniquet_Entree;
	}

	public ArrayList<Ticket> getListe_Ticket_tourniquet_Entree() {
		return Liste_Ticket_tourniquet_Entree;
	}

	public void setListe_Ticket_tourniquet_Entree(ArrayList<Ticket> liste_Ticket_tourniquet_Entree) {
		Liste_Ticket_tourniquet_Entree = liste_Ticket_tourniquet_Entree;
	}


	public int getId_Tourniquet_Entree() {
		return id_Tourniquet_Entree;
	}


	public void setId_Tourniquet_Entree(int id_Tourniquet_Entree) {
		this.id_Tourniquet_Entree = id_Tourniquet_Entree;
	}
}

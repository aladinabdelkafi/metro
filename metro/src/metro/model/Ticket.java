package  metro.model;


import java.sql.Date;

public class Ticket {
private int Num;
private Date date_heure_achat;
private Date date_heure_entre;
private Date date_heure_sortie;
private Guichet guichet;
private Zonne zonne;
private Type_Ticket type;
private Tourniquet_Entree tourniquet_Entree;
private Tourniquet_Sortie tourniquet_Sortie;


public Ticket() {}

public Ticket(int num, Date date_heure_achat, Date date_heure_entre, Date date_heure_sortie,Type_Ticket type) {
	Num = num;
	this.date_heure_achat = date_heure_achat;
	this.date_heure_entre = date_heure_entre;
	this.date_heure_sortie = date_heure_sortie;
	this.type=type;
}


public Ticket(int num, Date date_heure_achat, Date date_heure_entre, Date date_heure_sortie, Guichet guichet,
		Zonne zonne, Type_Ticket type, Tourniquet_Entree tourniquet_Entree, Tourniquet_Sortie tourniquet_Sortie) {
	super();
	Num = num;
	this.date_heure_achat = date_heure_achat;
	this.date_heure_entre = date_heure_entre;
	this.date_heure_sortie = date_heure_sortie;
	this.guichet = guichet;
	this.zonne = zonne;
	this.type = type;
	this.tourniquet_Entree = tourniquet_Entree;
	this.tourniquet_Sortie = tourniquet_Sortie;
}

public Ticket(int num, Date date_heure_achat, Date date_heure_entre, Date date_heure_sortie,Type_Ticket type, Guichet guichet,
		Zonne zonne) {
	Num = num;
	this.date_heure_achat = date_heure_achat;
	this.date_heure_entre = date_heure_entre;
	this.date_heure_sortie = date_heure_sortie;
	this.guichet = guichet;
	this.zonne = zonne;
	this.type=type;
}
public int getNum() {
	return Num;
}
public void setNum(int num) {
	Num = num;
}
public Date getDate_heure_achat() {
	return date_heure_achat;
}
public void setDate_heure_achat(Date date_heure_achat) {
	this.date_heure_achat = date_heure_achat;
}
public Date getDate_heure_entre() {
	return date_heure_entre;
}
public void setDate_heure_entre(Date date_heure_entre) {
	this.date_heure_entre = date_heure_entre;
}
public Date getDate_heure_sortie() {
	return date_heure_sortie;
}
public void setDate_heure_sortie(Date date_heure_sortie) {
	this.date_heure_sortie = date_heure_sortie;
}
public Guichet getGuichet() {
	return guichet;
}
public void setGuichet(Guichet guichet) {
	this.guichet = guichet;
}
public Zonne getZonne() {
	return zonne;
}
public void setZonne(Zonne zonne) {
	this.zonne = zonne;
}

public Type_Ticket getType() {
	return type;
}

public void setType(Type_Ticket type) {
	this.type = type;
}

public Tourniquet_Entree getTourniquet_Entree() {
	return tourniquet_Entree;
}

public void setTourniquet_Entree(Tourniquet_Entree tourniquet_Entree) {
	this.tourniquet_Entree = tourniquet_Entree;
}

public Tourniquet_Sortie getTourniquet_Sortie() {
	return tourniquet_Sortie;
}

public void setTourniquet_Sortie(Tourniquet_Sortie tourniquet_Sortie) {
	this.tourniquet_Sortie = tourniquet_Sortie;
}

}

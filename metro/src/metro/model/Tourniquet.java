package  metro.model;



public class Tourniquet {
protected int Num_tourniquet;
protected Station station;

public Tourniquet() {
	
}


public Tourniquet(int num_tourniquet, Station station) {
	super();
	Num_tourniquet = num_tourniquet;
	this.station = station;
}


public int getNum_tourniquet() {
	return Num_tourniquet;
}
public void setNum_tourniquet(int num_tourniquet) {
	Num_tourniquet = num_tourniquet;
}
public Station getStation() {
	return station;
}
public void setStation(Station station) {
	this.station = station;
}

}

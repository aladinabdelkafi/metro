package metro.model;

public class Rolle {
private int id_rolle;
private String type_rolle;


public Rolle() {
	
}
public Rolle(int id_rolle, String type_rolle) {
	super();
	this.id_rolle = id_rolle;
	this.type_rolle = type_rolle;
}
public int getId_rolle() {
	return id_rolle;
}
public void setId_rolle(int id_rolle) {
	this.id_rolle = id_rolle;
}
public String getType_rolle() {
	return type_rolle;
}
public void setType_rolle(String type_rolle) {
	this.type_rolle = type_rolle;
}
@Override
public String toString() {
	return "Rolle [id_rolle=" + id_rolle + ", type_rolle=" + type_rolle + "]";
}




}

package metro.model;

public class User {
private int id_user;
private String login;
private String pass;
private Rolle  rolle;
private Guichet guichet;
public User(int id_user, String login, String pass, Rolle rolle,Guichet guichet) {
	
	this.id_user = id_user;
	this.login = login;
	this.pass = pass;
	this.rolle = rolle;
	this.guichet=guichet;
}
public User() {
	
}
public int getId_user() {
	return id_user;
}
public void setId_user(int id_user) {
	this.id_user = id_user;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public Rolle getRolle() {
	return rolle;
}
public void setRolle(Rolle rolle) {
	this.rolle = rolle;
}
public Guichet getGuichet() {
	return guichet;
}
public void setGuichet(Guichet guichet) {
	this.guichet = guichet;
}
@Override
public String toString() {
	return "User [id_user=" + id_user + ", login=" + login + ", pass=" + pass + ", rolle=" + rolle + ", guichet="
			+ guichet + "]";
}




}

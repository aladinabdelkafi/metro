package metro.model;

public class Count {
private String db;
private int count;
public Count() {
	
}

public Count(String db, int count) {
	super();
	this.db = db;
	this.count = count;
}
public String getDb() {
	return db;
}
public void setDb(String db) {
	this.db = db;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}

}

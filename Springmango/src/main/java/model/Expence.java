package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("expence")
public class Expence {
@Id
private String  id;
@Field(name="catogry")
@Indexed(unique = true)
private Expencecatogry expence;
@Field(name="name")
private String Expencename;
public Expence() {
	super();
	// TODO Auto-generated constructor stub
}
public Expence(String id, Expencecatogry expence, String expencename) {
	super();
	this.id = id;
	this.expence = expence;
	Expencename = expencename;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Expencecatogry getExpence() {
	return expence;
}
public void setExpence(Expencecatogry expence) {
	this.expence = expence;
}
public String getExpencename() {
	return Expencename;
}
public void setExpencename(String expencename) {
	Expencename = expencename;
}
@Override
public String toString() {
	return "Expence [id=" + id + ", expence=" + expence + ", Expencename=" + Expencename + "]";
}


}

package user.service.entity.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;



@Entity
@Table(name="mychoice_users")
public class Users {
@Id
@Column(name = "ID")
private String userId;
@Column(name ="NAME",length=20)
	private String name;
@Column(name="EMAIL")
@Email
	private String email;
@Column(name="ABOUT")
	private String about;
@Transient
private List<Rating> ratings;



public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Users [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + ", ratings="
			+ ratings + "]";
}
public String getAbout() {
	return about;
}
public void setAbout(String about) {
	this.about = about;
}
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(String userId, String name, @Email String email, String about, List<Rating> ratings) {
	super();
	this.userId = userId;
	this.name = name;
	this.email = email;
	this.about = about;
	this.ratings = ratings;
}
public List<Rating> getRatings() {
	return ratings;
}
public void setRatings(List<Rating> ratings) {
	this.ratings = ratings;
}




}

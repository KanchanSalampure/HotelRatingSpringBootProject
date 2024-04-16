package rating.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_ratings")
public class Rating {
	@Id
	private String ratingId;
	private String userid;
	private String hotel;
	private int rating;
	private String feedback;
	public Rating(String ratingId, String userid, String hotel, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userid = userid;
		this.hotel = hotel;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userid=" + userid + ", hotel=" + hotel + ", rating=" + rating
				+ ", feedback=" + feedback + "]";
	}
	
	
}

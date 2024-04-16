package rating.service;

import java.util.List;

import rating.entity.Rating;

public interface RatingService {

	//careate 
	Rating createRating(Rating rating);
	//get all rating
	List<Rating> getAllRating();
	 //get by Userid
	List<Rating> getRatingByUserID(String userId);
	//get rating by hotel
	List<Rating> getRatingByHotelID(String hotelId);
	
}

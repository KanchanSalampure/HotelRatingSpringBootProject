package rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rating.entity.Rating;
import ratingRepo.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService {
   @Autowired
    private RatingRepository ratingRepository;
	
    @Override
	public Rating createRating(Rating rating) {
    	
    	String id=UUID.randomUUID().toString();
    	rating.setRatingId(id);
		Rating r= ratingRepository.save(rating);
		System.out.println("rating"+r);
		return r;
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserID(String userId) {
		
		return ratingRepository.findByUserid(userId);
	}

	@Override
	public List<Rating> getRatingByHotelID(String hotelId) {
		
		return ratingRepository.findByHotel(hotelId);
	}

}

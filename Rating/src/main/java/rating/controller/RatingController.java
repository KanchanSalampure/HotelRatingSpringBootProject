package rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rating.entity.Rating;
import rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
	private RatingService ratingservice;
    
    @PostMapping
    public ResponseEntity<Rating> save(@RequestBody Rating rating) {
    	Rating r=ratingservice.createRating(rating);
    	return new ResponseEntity<>(r,HttpStatus.OK);
	
    }
	@GetMapping("/getall")
	public ResponseEntity<List<Rating>> getAllRating(){
	List<Rating> rlist=ratingservice.getAllRating();
	return new ResponseEntity<>(rlist,HttpStatus.OK);
	}
	
	@GetMapping("/UserRating/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
		List<Rating> hlist=ratingservice.getRatingByUserID(userId);
		return new ResponseEntity<>(hlist,HttpStatus.OK);
		}
	
	@GetMapping("/HotelRating/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelID(@PathVariable String hotelId){
		List<Rating> hlist=ratingservice.getRatingByHotelID(hotelId);
		return new ResponseEntity<>(hlist,HttpStatus.OK);
		}
}

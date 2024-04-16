package hotel.service;

import java.util.List;

import hotel.entity.Hotel;

public interface HotelService {
//create 
	Hotel create(Hotel hotel);
	
//get all
	List<Hotel> getall();
//get by id
	Hotel hotelgetbyid(String id);
}

package hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.Repo.HotelRepositry;
import hotel.entity.Hotel;
import hotel.exception.ResouceNotFoundException;
@Service
public class HotelServiceIImp implements HotelService {
    @Autowired
	HotelRepositry hotelrepo;
	@Override
	public Hotel create(Hotel hotel) {
	String hotelid=UUID.randomUUID().toString();
	hotel.setHotelid(hotelid);
	Hotel h=hotelrepo.save(hotel);
	System.out.println("h  = "+h);
		return h;
	}

	@Override
	public List<Hotel> getall() {
		List<Hotel> lh=hotelrepo.findAll();
		System.out.println("lh = "+lh);	
		return lh;
	}

	@Override
	public Hotel hotelgetbyid(String id) {
		try {
		Hotel h1=hotelrepo.findById(id).orElseThrow(()->new ResouceNotFoundException("Hotel with  goven id is not found"));
		return h1;
		}catch(Exception e) {
			e.printStackTrace();
			return new Hotel();	
		}
	}

}
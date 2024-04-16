package hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hotel.entity.Hotel;
import hotel.service.HotelService;


@RestController
@RequestMapping("/hotel")
public class HotelController {
	private Logger log=LoggerFactory.getLogger(HotelController.class);
   @Autowired
	private HotelService hotelservice;
	
   @PostMapping
   public ResponseEntity<Hotel> createhotel(@RequestBody Hotel hotel){
	Hotel h=hotelservice.create(hotel);
	   return new ResponseEntity<>(hotel,HttpStatus.OK);
   }
	@GetMapping
	public ResponseEntity<List<Hotel>> getallhotel(){
		List<Hotel> listh=hotelservice.getall();
		return new  ResponseEntity<>(listh,HttpStatus.OK);
	}

	@GetMapping("/{hotelid}")
	public ResponseEntity<Hotel> getbyid(@PathVariable String hotelid){
		log.info("hotelid inside hotecontroller ={}  ",hotelid);
		Hotel h=hotelservice.hotelgetbyid(hotelid);
		return new ResponseEntity<>(h,HttpStatus.OK);
	}
}

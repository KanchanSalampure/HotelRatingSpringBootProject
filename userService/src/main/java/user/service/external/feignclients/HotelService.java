package user.service.external.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import user.service.entity.user.Hotel;

@FeignClient(name="Hotel")
public interface HotelService {
	
	@GetMapping("/hotel/{hotelid}")
	Hotel getHotel(@PathVariable("hotelid") String hotelid);

}

package user.service.service.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import user.service.entity.user.Hotel;
import user.service.entity.user.Rating;
import user.service.entity.user.Users;
import user.service.exception.ResoursceNotFoundException;
import user.service.external.feignclients.HotelService;
import user.service.repository.user.UserRepository;
@Service
public class UserServiceImp implements UserService {
 
	private Logger log=LoggerFactory.getLogger(UserServiceImp.class);
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Users saveuser(Users user) {
	String ramdomUserID=UUID.randomUUID().toString();
		user.setUserId(ramdomUserID);
	return userrepo.save(user);
	}

	@Override
	public List<Users> getallUsers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public Users getusers(String id) {
		
		
		Users u= userrepo.findById(id).orElseThrow(() -> new ResoursceNotFoundException("User give id Not found ="+id));
		// http://localhost:8084/rating//UserRating/39ceb1ab-ad09-46d7-b01f-256e3ce8f50b
		//url and type of object your expecting form getForObject method
	    Rating[] forobject=restTemplate.getForObject("http://RATING/rating/UserRating/"+u.getUserId(),Rating[].class);
        List<Rating> rlist	=Arrays.asList(forobject);
	    
	    log.info("forobject ={}",rlist);
	   
	   
	    for(Rating r:rlist) {
//	    	log.info("hotel id ={}",r.getHotelobj().getHotelid());
	    //	r.setHotelobj(restTemplate.getForEntity("http://HOTEL/hotel/"+r.getHotel(), Hotel.class).getBody());
	    	r.setHotelobj(hotelService.getHotel(r.getHotel()));
	    	log.info("hotel ={}",r.getHotelobj());
	    }
	    u.setRatings(rlist);
	    log.info("user  ={}",u);
	    
	return u;
	}

}

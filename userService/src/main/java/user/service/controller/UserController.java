package user.service.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import user.service.entity.user.Users;
import user.service.service.user.UserService;
import user.service.service.user.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	UserService userService;
	private Logger log=LoggerFactory.getLogger(UserController.class);
@PostMapping
public ResponseEntity<Users> createusers(@RequestBody Users user){
	System.out.println("User"+user);
	Users u=userService.saveuser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(u);
}
	

@GetMapping("/{userid}")
@CircuitBreaker(name ="ratingHotelCB",fallbackMethod = "ratingHotelFallBack")
public ResponseEntity<Users> getUserByid(@PathVariable String userid){
	Users u1=userService.getusers(userid);
	System.out.println("User get by id"+userid+"and the object against it is ="+u1);
	return ResponseEntity.status(HttpStatus.FOUND).body(u1);
	
}


//cearting fallback method for circuit braker  
public ResponseEntity<Users> ratingHotelFallBack(String userid,Exception ex){
	log.info("ratingHotelFallBack Fallback is executed is message ={} ",ex.getMessage());

	Users u=new Users();
	u.setName("Dummuy");
	u.setEmail("DummuyEmail@gmail.com");
	u.setAbout("This is used when same service is down");
	u.setUserId("12344321");
	u.setRatings(null);
	return new ResponseEntity<>(u,HttpStatus.OK);
}


@GetMapping("/getall")
public ResponseEntity<List<Users>> getallUsers(){
	List<Users> userList=userService.getallUsers();
return new ResponseEntity<>(userList,HttpStatus.OK);
}
}

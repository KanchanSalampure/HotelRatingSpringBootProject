package user.service.controller;

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

import user.service.entity.user.Users;
import user.service.service.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	UserService userService;
    
    //create user
@PostMapping
public ResponseEntity<Users> createusers(@RequestBody Users user){
	System.out.println("User"+user);
	Users u=userService.saveuser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(u);
}
	

@GetMapping("/{userid}")
public ResponseEntity<Users> getUserByid(@PathVariable String userid){
	Users u1=userService.getusers(userid);
	System.out.println("User get by id"+userid+"and the object against it is ="+u1);
	return ResponseEntity.status(HttpStatus.FOUND).body(u1);
	
}


@GetMapping("/getall")
public ResponseEntity<List<Users>> getallUsers(){
	List<Users> userList=userService.getallUsers();
return new ResponseEntity<>(userList,HttpStatus.OK);
}
}

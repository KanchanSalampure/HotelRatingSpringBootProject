package Controller;

import javax.swing.RepaintManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.ExpenceService;
import model.Expence;
import repository.Mongotinerface;

@RestController
@RequestMapping("/api/expence")
public class ExpenceController {
private final ExpenceService expserv;
	
	
	public ExpenceController(ExpenceService expserv) {
	super();
	this.expserv = expserv;
}
	public ResponseEntity addexp(@RequestBody Expence exp )
	 {
		expserv.addexp(exp);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	 }
	 public void geteexp() {
		 
	 }
	 public void deleteecp()
	 {
		 
	 }
}

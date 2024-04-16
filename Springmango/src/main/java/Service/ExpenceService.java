package Service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.Expence;
import repository.Mongotinerface;
 
@Service
public class ExpenceService {

	private  Mongotinerface expRepo;
	
 public ExpenceService(Mongotinerface expRepo) {
		super();
		this.expRepo = expRepo;
	}
public void addexp(Expence exp) {
		 expRepo.insert(exp);
		 //return ResponseEntity.status(HttpStatus.cre)
				 }
	 public void geteexp() {
		expRepo.findAll(); 
	 }
	 public void deleteecp()
	 {
		 //expRepo.delete(exp);
	 }
}


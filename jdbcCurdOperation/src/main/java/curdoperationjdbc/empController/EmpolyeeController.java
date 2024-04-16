package curdoperationjdbc.empController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import curdoperationjdbc.empmodel.Empolyee;
import curdoperationjdbc.empservice.EmployeeServiceInterface;


@RestController
public class EmpolyeeController {

	@Autowired
	EmployeeServiceInterface emplInterface;
	
	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<List<Empolyee>> addData(@RequestBody Empolyee  emp) throws Exception {
		System.out.println("emp"+emp);
		List<Empolyee> result=emplInterface.addemp(emp);
	return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@GetMapping("/get")
	public ResponseEntity<Empolyee> get(){
		System.out.println("hiii in get");
		return null;
			
		}
	
}

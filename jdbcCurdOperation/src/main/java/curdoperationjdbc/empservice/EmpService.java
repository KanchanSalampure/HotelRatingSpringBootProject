package curdoperationjdbc.empservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curdoperationjdbc.empdao.EmpDaoInterface;
import curdoperationjdbc.empmodel.Empolyee;
@Service
public class EmpService implements EmployeeServiceInterface {
@Autowired
	EmpDaoInterface empDaoInterface;

	@Override
	public List<Empolyee> addemp(Empolyee emp) {
		System.out.println("inside EmpService emp="+emp);
		return empDaoInterface.addemp(emp);
	}

	
}

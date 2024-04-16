package curdoperationjdbc.empdao;

import java.util.List;

import curdoperationjdbc.empmodel.Empolyee;

public interface EmpDaoInterface {

	public List<Empolyee> addemp(Empolyee emp);
	public List<Empolyee> update(Empolyee emp);
	
}

package curdoperationjdbc.empmodel;

public class Empolyee {
	int empid;
	String empolyeName;
	double empolyeeSalary;
	String empolyeeAddress;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpolyeName() {
		return empolyeName;
	}
	public void setEmpolyeName(String empolyeName) {
		this.empolyeName = empolyeName;
	}
	public double getEmpolyeeSalary() {
		return empolyeeSalary;
	}
	public void setEmpolyeeSalary(double empolyeeSalary) {
		this.empolyeeSalary = empolyeeSalary;
	}
	public String getEmpolyeeAddress() {
		return empolyeeAddress;
	}
	public void setEmpolyeeAddress(String empolyeeAddress) {
		this.empolyeeAddress = empolyeeAddress;
	}
	@Override
	public String toString() {
		return "emp [empid=" + empid + ", empolyeName=" + empolyeName + ", empolyeeSalary=" + empolyeeSalary
				+ ", empolyeeAddress=" + empolyeeAddress + "]";
	}
	
	

}

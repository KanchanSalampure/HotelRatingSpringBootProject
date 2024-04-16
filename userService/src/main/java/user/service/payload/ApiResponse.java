package user.service.payload;

import org.springframework.http.HttpStatus;


public class ApiResponse {
private String messgae;
private boolean sucess;
private HttpStatus status;
public String getMessgae() {
	return messgae;
}
public void setMessgae(String messgae) {
	this.messgae = messgae;
}
public boolean isSucess() {
	return sucess;
}
public void setSucess(boolean sucess) {
	this.sucess = sucess;
}
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public ApiResponse(String messgae, boolean sucess, HttpStatus status) {
	super();
	this.messgae = messgae;
	this.sucess = sucess;
	this.status = status;
}
public ApiResponse() {
	super();
	// TODO Auto-generated constructor stub
}


}

package user.service.exception;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import user.service.payload.ApiResponse;
@RestController
public class GlobalExceptionHandlermy {
    @ExceptionHandler(ResoursceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundException( ResoursceNotFoundException rs){
		String message =rs.getMessage();
		ApiResponse get=new ApiResponse();
	get.setMessgae(message);
	get.setStatus(HttpStatus.NOT_FOUND);
    get.setSucess(true);	
    return new ResponseEntity<ApiResponse>(get,HttpStatus.NOT_FOUND);
		
	}
}

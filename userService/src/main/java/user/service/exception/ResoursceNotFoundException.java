package user.service.exception;

public class ResoursceNotFoundException extends RuntimeException {

	
	public ResoursceNotFoundException() {
		super("Resource Not Found Custom Excepotion !!");
	
	}
	public ResoursceNotFoundException(String message) {
		super(message);
	}
}

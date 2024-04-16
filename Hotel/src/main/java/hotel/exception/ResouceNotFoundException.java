package hotel.exception;

public class ResouceNotFoundException extends RuntimeException {

	public ResouceNotFoundException() {
		super("Resource Not Custom Exception");
	}
	public ResouceNotFoundException (String msg) {
		super(msg);
	}
}

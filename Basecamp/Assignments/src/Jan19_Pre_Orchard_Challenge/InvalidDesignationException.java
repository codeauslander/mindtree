package Jan19_Pre_Orchard_Challenge;

public class InvalidDesignationException extends Exception {
	String message;
	public InvalidDesignationException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}

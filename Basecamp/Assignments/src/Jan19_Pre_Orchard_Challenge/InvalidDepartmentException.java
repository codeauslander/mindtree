package Jan19_Pre_Orchard_Challenge;

public class InvalidDepartmentException extends Exception {
	String message;
	public InvalidDepartmentException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}

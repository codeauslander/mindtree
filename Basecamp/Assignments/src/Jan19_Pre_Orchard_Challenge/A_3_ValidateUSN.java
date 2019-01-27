package Jan19_Pre_Orchard_Challenge;
import java.util.regex.*;
import java.util.Scanner;

public class A_3_ValidateUSN {
	public static void printResult(boolean match) {
		if(match){
    	   System.out.println("Success");
       } else {
    	   System.err.println("Failure");
       }
	}
	public static boolean validateUSN(String usn) {
		String regularExpression = "\\A([12])([A-Z])([A-Z])([0-9])([0-9])(CS)|(IS)|(EC)|(ME)([0-9])([0-9])([0-9]{10})\\Z";
	    Pattern pattern = Pattern.compile(regularExpression);
	    boolean matchExpression = pattern.matcher(usn).find();
	    boolean matchLength = usn.length() == 10 ? true : false;
		return (matchExpression && matchLength);
	}
	public static boolean validateUSN2(String usn) {
		char[] letters = usn.toCharArray();
		int amountLetters = letters.length;
		if(amountLetters != 10) {
			return false;
		}
	    for (int index = 0; index < amountLetters; index++) {
	    	char letter = letters[index];
			switch(index) {
				case 0:
					if(!(letter == '1' || letter == '2')) {
						return false;
					}
					break;
				case 1:
					if(!(letter >= 'A' && letter <= 'Z')) {
						return false;
					}
					break;
				case 2:
					if(!(letter >= 'A' && letter <= 'Z')) {
						return false;
					}
					break;
				case 3:
					if(!(letter >= '0' && letter <= '9')) {
						return false;
					}
				case 4:
					if(!(letter >= '0' && letter <= '9')) {
						return false;
					}
					break;
				case 5:
					if(index + 1 < amountLetters) {
						boolean CS = (letter == 'C' && letters[index+1] == 'S');
						boolean IS = (letter == 'I' && letters[index+1] == 'S');
						boolean EC = (letter == 'E' && letters[index+1] == 'C');
						boolean ME = (letter == 'M' && letters[index+1] == 'E');
						if(!(CS || IS || EC || ME)) {
							return false;
						}
					}
					break;
				case 7:
					if(!(letter >= '0' && letter <= '9')) {
						return false;
					}
					break;
				case 8:
					if(!(letter >= '0' && letter <= '9')) {
						return false;
					}
					break;
				case 10:
					if(!(letter >= '0' && letter <= '9')) {
						return false;
					}
					break;
				default:
					System.out.println(usn);
				
			}
		}
	    return true;
	}
	public static void main(String []argh){
       Scanner userInput = new Scanner(System.in);
//       String usn = userInput.nextLine();
       userInput.close();
       String usn1 = "1DS09CS010";
       printResult(validateUSN(usn1));
       printResult(validateUSN2(usn1));
    }
}

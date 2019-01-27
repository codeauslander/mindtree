package Jan19_Basecamp_HackerEarth;
import java.util.Scanner;
//class TestClass {
public class Cipher {
	public static char topLimitCharacterAjust(char character) {
		if (character > 'z') {
			character = 'a';
		}else if (character > 'Z' && character < 'a') {
			character = 'A';
		} else if (character > '9' && character < 'A') {
			character = '0';
		}
		return character;
	}
	public static char lowerLimitCharacterAjust(char character) {
		if (character < '0') {
			character = '9';
		}else if (character < 'A' && character > '9') {
			character = 'Z';
		} else if (character < 'a' && character > 'Z') {
			character = 'z';
		}
		return character;
	}
	public static char rotateCharacter(char character, int number) {
		int movement = 0;
		while (movement < number) {
			character = (char) (character + 1);
			character = topLimitCharacterAjust(character);
			character = lowerLimitCharacterAjust(character);
			movement++;
		}
		return character;
	}
	public static boolean validCharacter(char character) {
		boolean isletterLowerCase = (character >= 'a' && character <= 'z');
		boolean isletterUpperCase = (character >= 'A' && character <= 'Z');
		boolean isNumber = (character >= '0' && character <= '9');
		return isletterLowerCase || isletterUpperCase || isNumber;
	}
	public static String encryptText(String text, int number) {
		int textLengt = text.length();
		for (int index = 0; index < textLengt; index++) {
			char character = text.charAt(index);
			if (validCharacter(character)) {
				character = rotateCharacter(character, number);
			}
			text = text.substring(0,index) + character + text.substring(index + 1);
		}
		return text;
	}
	public static void main(String[] args) {
//		testUserInput();
		testDry();
	}
	public static void testUserInput() {
		Scanner inputUser = new Scanner(System.in);
		String text = inputUser.nextLine().trim();
		int number = inputUser.nextInt();
		String encryptedText = encryptText(text, number);
		System.out.println(encryptedText);

	}
	public static void testDry() {
		String text = "All-convoYs-9-be:Alert1";
		String result = "Epp-gsrzsCw-3-fi:Epivx5";
	
		int number = 4;
		String encryptedText = encryptText(text, number);
		
		System.out.println("Input text: " + text);
		System.out.println("Output text: " + encryptedText);
		System.out.println("Test pass: " + encryptedText.equals(result));
	}
}

package Class;

import java.util.Scanner;

public class TestOne_SwichText {
	
	public static String switchText(String text) {
		final int GAP_ISCII = 32;
		int textLength = text.length();
		for (int index = 0; index < textLength; index++) {
			char letter = text.charAt(index);
			if(letter >= 'a' && letter <= 'z') {
				letter = (char) (letter -  GAP_ISCII);
			} else if(letter >= 'A' && letter <= 'Z'){
				letter = (char) (letter +  GAP_ISCII);
			}
			text = text.substring(0,index) + letter + text.substring(index + 1);
		}
		return text;
	}

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter text: ");
//		String inputUser = scanner.nextLine();
//		System.out.println("Answer: " + switchText(inputUser));
		
		String inputUserOne = "wELcome To pOssIbLE";
		String inputUserTwo = "WelCOME tO PoSSiBle";
		
		System.out.println("Text to switch: " + inputUserOne);
		String switchedTextOne = switchText(inputUserOne);
		System.out.println("Text switched: " + switchedTextOne);
		System.out.println();
		System.out.println("Text to switch: " + inputUserTwo);
		String switchedTextTwo = switchText(inputUserTwo);
		System.out.println("Text switched: " + switchedTextTwo);
		System.out.println();
		System.out.println("It works? " + (switchedTextOne.equals(inputUserTwo)));
		System.out.println("It works? " + (switchedTextTwo.equals(inputUserOne)));
	}
}

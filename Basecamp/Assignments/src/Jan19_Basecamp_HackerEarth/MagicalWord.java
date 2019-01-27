//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/
package Jan19_Basecamp_HackerEarth;
import java.util.Scanner;
//public class TestClass {
public class MagicalWord {
	public static boolean isPrime(int number, int divisor) {
		if(divisor < number) {
			if (number % divisor != 0) {
				return isPrime(number, divisor + 1);
			} else {
				return false;
			}
		}
		return true;
	}
	public static int closestLowerPrime(int number) {
		if (number > 2) {
			if(isPrime(number, 2)) {
				return number;
			}
			return closestLowerPrime(number - 1);
		}
		return number;
	}
	public static int closestHightPrime(int number) {
		if (number > 2) {
			if(isPrime(number, 2)) {
				return number;
			}
			return closestHightPrime(number + 1);
		}
		return number;
	}
	public static int closestPrime(int number) {
		int lowestPrime = closestLowerPrime(number);
		int higherPrime = closestHightPrime(number);
//		System.out.println("number: " + number + " higher: " + higherPrime + " lowest: " + lowestPrime);
		if ((number - lowestPrime) <= (higherPrime - number) ) {
			return lowestPrime;
		} else if((higherPrime - number) < (number - lowestPrime)) {
			return higherPrime;
		}
		return number;
	}
	public static char rotateCharacter(char character) {
		boolean isletterLowerCase = (character >= 'a' && character <= 'z') ;
		boolean isletterUpperCase = (character >= 'A' && character <= 'Z') ;
		boolean isNumber = (character >= '0' && character <= '9');
		if (isletterUpperCase) {
			character = (char) closestPrime((character));
			if (character < 'A') {
				character = (char) closestHightPrime((int) 'A');
			} else if(character > 'Z') {
				character = (char) closestLowerPrime((int) 'Z');
			}
		} else if(isletterLowerCase) {
			character = (char) closestPrime((character));
			if(character < 'a') {
				character = (char) closestHightPrime((int) 'a');
			} else if(character > 'z') {
				character = (char) closestLowerPrime((int) 'z');
			}
		} else if(character < 'A') {
			character = (char) closestPrime((character));
			if (character < 'A') {
				character = (char) closestHightPrime((int) 'A');
			} else if(character > 'Z') {
				character = (char) closestLowerPrime((int) 'Z');
			}
		} else if(character > 'z') {
			character = (char) closestPrime((character));
			if(character < 'a') {
				character = (char) closestHightPrime((int) 'a');
			} else if(character > 'z') {
				character = (char) closestLowerPrime((int) 'z');
			}
		} else {
			character = (char) closestPrime(character);
			while(validCharacter(character)) {
				character = (char) closestPrime(character);
			}
		}
		
		return character;
	}
	public static boolean validCharacter(char character) {
		boolean isletterLowerCase = (character >= 'a' && character <= 'z');
		boolean isletterUpperCase = (character >= 'A' && character <= 'Z');
		return isletterLowerCase || isletterUpperCase;
	}
	public static String encryptText(String text) {
		int textLengt = text.length();
		for (int index = 0; index < textLengt; index++) {
			char character = text.charAt(index);
//			if (validCharacter(character)) {
			character = rotateCharacter(character);
//			}
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
		int amountTests = inputUser.nextInt();
		while(amountTests-- > 0) {
			int amountLetters = inputUser.nextInt();
			String text = inputUser.next();
			String encryptedText = encryptText(text);
			System.out.println(encryptedText);
		}
	}
	public static void testDry() {
//		String text = "AFREEN";
//		String result = "CGSCCO";
		
//		String text = "AvfmaLgLRpQadLyThsxVzkUqbFOdxfbLGdpBWOwmAnflENlYFbdhNHerHVtZkaPLgMtNQovVHpwGfHJdXXWAhYrhwXKPxtnpxCIsaXVAkcxTpVprFNeOVcnSEsgIvfqXPRSUASSDCvAGrFJCDbzGLFhrMYWALElChmurLrEeQttIWctyhQXzZUVAYuCIZecBJbXMxlMHFbZxJRTSZJmZAwCggGabVsovqBrdmmbCTaIHDfUunLFntfGzodKqoAKwCassKMDybethRaQgegsOawfNCNrIAkECEKpbwElhvWtlZBEZqJQpEkzpiSjrqZZIHbszUxwuWreXkxFKxSAiKoemIqETGVxcCjweKhbyXxhVKCbNTQBKgHD";
//		String result = "CqemaIgISqOaeIqSgqqSqkSqaGOeqeaIGeqCYOqmCmekCOkYGaegOGeqGSqYkaOIgOqOOmqSGqqGeGIeYYYCgYqgqYIOqqmqqCIqaYSCkaqSqSqqGOeOSamSCqgIqeqYOSSSCSSCCqCGqGICCaqGIGgqOYYCICkCgmqqIqCeOqqIYaqqgOYqYSSCYqCIYeaCIaYOqkOGGaYqISSSYImYCqCggGaaSqmqqCqemmaCSaIGCeSqmIGmqeGqmeIqmCIqCaqqIOCqaeqgSaOgegqOaqeOCOqICkCCCIqaqCkgqYqkYCCYqIOqCkqqgSkqqYYIGaqqSqqqYqeYkqGIqSCgImemIqCSGSqaCkqeIgaqYqgSICaOSOCIgGC";

		String text = "51012345678908S@#!#$op6S#!v@m11!@#$%^&*()_15+=-\\|]}[{'\";:><";
		String result = "CCCCCCCCCCSCCCCCmqSCCqCmCCCCCaCCCCaCCCYqYqYqCCCCCC";
		
		String encryptedText = encryptText(text);
		
		System.out.println("Input text:  " + text);
		System.out.println("Output text: " + encryptedText);
		System.out.println("Should be:   " + result);
		System.out.println("Test pass: " + encryptedText.equals(result));
	}
}

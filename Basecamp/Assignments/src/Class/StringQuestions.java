package Class;
import java.util.Arrays;
public class StringQuestions {
//	1.       Write a program to count the unique letters, spaces, numbers and other special characters of an input string.
//	2.       Write a program to get the character at the given index within the String
//	3.       Write a program to concatenate a given string to the end of another string
//	4.       Write a program to sequence all the character of a string [a-z]
//	5.       Write a program to test if a given string contains the specified sequence of char values
	
	public static char getCharacterAtIndex(String text, int index) {
		return text.charAt(index);
	}
	public static int countCharacter(String text, char character) {
		int counter = 0;
		int textLength = text.length();
		for (int index = 0; index < textLength; index++) {
			char currentCharacter = text.charAt(index);
			if (currentCharacter == character) {
				counter++;
			}
		}
		return counter;
	}
	public static int countUniqueCharacters(String text) {
		int counter = 0;
		int textLength = text.length();
		for (int index = 0; index < textLength; index++) {
			char character = text.charAt(index);
			if (countCharacter(text, character) == 1) {
				counter++;
			}
		}
		return counter;
	}
	public static String concatenateTwoStrings(String text, String plusText) {
		char[] originalText = text.toCharArray();
		int originalTextLength = originalText.length;
		
		char[] extraText = plusText.toCharArray();
		int extraTextLength = extraText.length;
		
		char[] newText = new char[originalTextLength + extraTextLength];
		int newTextLength = newText.length;
		
		for (int index = 0; index < newTextLength; index++) {
			if (index < originalTextLength) {
				newText[index] = originalText[index];
			} else {
				newText[index] = extraText[index - originalTextLength];
			}
		}
		
		String resultConcatenate = new String(newText);
		return resultConcatenate;
	}
	public static boolean isSequenceInText(String text, String sequence) {
		char[] originalText = text.toCharArray();
		int originalTextLength = originalText.length;
		
		char[] sequenceText = sequence.toCharArray();
		int sequenceTextLength = sequenceText.length;
		
		int searchLength = originalTextLength - sequenceTextLength;
		for (int index = 0; index < searchLength; index++) {
			char characterText = originalText[index];
			char characterSequence = sequenceText[0];
			if(characterText == characterSequence) {
				boolean result = true;
				for (int sequenceIndex = 0; sequenceIndex < sequenceTextLength; sequenceIndex++) {
					characterText = originalText[sequenceIndex + index];
					characterSequence = sequenceText[sequenceIndex];
					if (characterText != characterSequence) {
						result = false;
					}
				}
				if (result) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		testDRY();
	}
	public static void testDRY() {
		System.out.println("String Questions");
		String text = "Welcome To Possible 101.";
		System.out.println("Text: " + text + " Length of the text: " + text.length());
		System.out.println();
		
		System.out.println("1. Write a program to count the unique letters, spaces, numbers and other special characters of an input string.");
		int resultCountUniqueCharacters = countUniqueCharacters(text);
		System.out.println("Text: " + text);
		System.out.println("Unique characters: " + resultCountUniqueCharacters);
		System.out.println();

		System.out.println("2. Write a program to get the character at the given index within the String");
		int index = 2;
		int resultGetCharacterAtIndex = getCharacterAtIndex(text, index);
		System.out.println("Text: " + text);
		System.out.println("Index: " + index);
		System.out.println("Character: " + resultGetCharacterAtIndex);
		System.out.println();
		
		System.out.println("3. Write a program to concatenate a given string to the end of another string");
		System.out.println("Text: " + text);
		String plusText = " Enjoy!";
		System.out.println("Plus Text: " + plusText);
		String resultConcatenateTwoStrings = concatenateTwoStrings(text, plusText);
		System.out.println("New text: " + resultConcatenateTwoStrings);
		System.out.println();
		
		System.out.println("4. Write a program to sequence all the character of a string [a-z]");
		
		System.out.println();
		
		System.out.println("5. Write a program to test if a given string contains the specified sequence of char values");
		String textWithSequence = "AnkitzzzMindTree";
		String sequence = "zzz";
		System.out.println("Text: " + textWithSequence);
		System.out.println("Sequence: " + sequence);
		boolean resultIsSequenceInText = isSequenceInText(textWithSequence, sequence);
		System.out.println("Is sequence inside text ?. " + resultIsSequenceInText);
		System.out.println();
	}
}

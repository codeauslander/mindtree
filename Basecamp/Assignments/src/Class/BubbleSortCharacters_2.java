package Class;
public class BubbleSortCharacters_2 {
	public static char charToLowerCase(char character) {
		boolean isletterUpperCase = (character >= 'A' && character <= 'Z');
		if (isletterUpperCase) {
			character = (char) (character + 32);
		}
		return character;
	}
	public static boolean swapableCharacters(char leftChar, char rightChar) {
		char left = charToLowerCase(leftChar);
		char right = charToLowerCase(rightChar);
		if (left > right) {
			return true;
		}
		return false;
	}
	public static String bubbleSort(String sentence) {
		int sentenceLength = sentence.length();
		boolean swapped = false;
		do {
		     swapped = false;
		     for (int index = 1; index < sentenceLength; index++) {
		    	char leftChar = sentence.charAt(index - 1);
				char rightChar = sentence.charAt(index);
				if (swapableCharacters(leftChar,rightChar)) {
					sentence = sentence.substring(0,index - 1) + rightChar + sentence.substring(index);
					sentence = sentence.substring(0,index) + leftChar + sentence.substring(index + 1);
					swapped = true;
				}
			}
		    sentenceLength--;
		} while (swapped);
        return sentence;
	}
	public static void main(String[] args) {
		testDry();
	}
	public static void testDry() {
		String sentence = "Welcome To Possible.";
		String resultBubbleSort = bubbleSort(sentence);
		System.out.println("Sentence: " + sentence);
		System.out.println("Sorted Sentence: " + resultBubbleSort);
	}
}
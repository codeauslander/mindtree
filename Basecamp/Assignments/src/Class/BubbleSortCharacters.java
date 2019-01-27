package Class;
import java.util.Scanner;
public class BubbleSortCharacters {
	public static int[] swap(int[] numbers, int leftIndex, int rightIndex) {
		int leftNumber = numbers[leftIndex];
		int rightNumber = numbers[rightIndex];
		int temporaryNumber = leftNumber;
		
		numbers[leftIndex] = rightNumber;
		numbers[rightIndex] = temporaryNumber;
		
		return numbers;
	}
	public static int[] bubbleSort(int[] numbers) {
		int numbersLength = numbers.length;
		boolean swapped = false;
		do {
		     swapped = false;
		     for (int index = 1; index < numbersLength; index++) {
				if (numbers[index - 1] > numbers[index]) {
					numbers = swap(numbers, index - 1, index);
					swapped = true;
				}
			}
		     numbersLength--;
		} while (swapped);
        return numbers;
	}
	public static int[] charactersToIntegers(char[] characters) {
		int charactersLength = characters.length;
		int[] asciiNumbers = new int[charactersLength];
		
		for (int index = 0; index < characters.length; index++) {
			asciiNumbers[index] = (int) (characters[index]);
		}
		return asciiNumbers;
	}
	public static char[] integersToCharacters(int[] asciiNumbers) {
		int asciiNumbersLength = asciiNumbers.length;
		char[] characters = new char[asciiNumbersLength];
		
		for (int index = 0; index < asciiNumbersLength; index++) {
			characters[index] = (char) (asciiNumbers[index]);
		}
		return characters;
	}
	public static String sortSentence(String sentence) {
		char[] sentenceCharacters = sentence.toCharArray();
		int[] asciiNumbers = charactersToIntegers(sentenceCharacters);
		asciiNumbers = bubbleSort(asciiNumbers);
		sentenceCharacters = integersToCharacters(asciiNumbers);
		String orderSentence = new String(sentenceCharacters);
		return orderSentence;
	}
	public static void main(String []argh){
		testDry();
    }
	public static void testUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter a sentence");
        String sentence = userInput.nextLine();
        userInput.close();
	}
	public static void testDry() {
		System.out.println("Sort Sentece character with bubble sort");
		String sentence = "Welcome To Possible.";
		String resultSortSentence = sortSentence(sentence);
		System.out.println("Sentence: " + sentence);
		System.out.println("Sorted Sentence: " + resultSortSentence);
		
	}
}

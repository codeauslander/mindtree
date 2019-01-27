package Jan19_Basecamp_HackerEarth;
//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/best-index-1-45a2f8ff/
import java.util.Arrays;
import java.util.Scanner;

//public class TestClass {
public class BestIndex_Recursively {
	public static int bestIndex(int[] numbers) {
		return maximumSpecialSum(numbers, 0, Integer.MIN_VALUE);
	}
	public static int sumAmountOfElements(int[] numbers, int index, int amount, int sum) {
		if(amount <= 0) {
			return sum;
		}
		sum += numbers[index];
		return sumAmountOfElements(numbers, index + 1, amount - 1, sum);
	}
	public static int specialSum(int[] numbers, int startIndex, int amount, int index, int sum) {
		if((index + amount) > numbers.length) {
			return sum;
		}
		if (index == 0) {
			index = startIndex;
		}
		sum += sumAmountOfElements(numbers, index, amount, 0);
		return specialSum(numbers, startIndex, amount + 1, index + amount, sum);
	}
	public static int maximumSpecialSum(int[] numbers, int index, int maximumSum) {
		if(index > numbers.length) {
			return maximumSum;
		}
		int resultSpecialSum = specialSum(numbers, index, 0, 0, 0);
		if (resultSpecialSum > maximumSum) {
			maximumSum = resultSpecialSum;
		}
		return maximumSpecialSum(numbers, index + 1, maximumSum);
	}
	public static void main(String[] args) {
//		testUserInput();
		testDry();
	}
	public static void testUserInput() {
		Scanner userInput = new Scanner(System.in);
		String stringAmountNumbers = userInput.nextLine().trim();
		int amountNumbers = Integer.parseInt(stringAmountNumbers);
		int[] numbers = new int[amountNumbers];
		String stringArray = userInput.nextLine();
		String[] numbersString = stringArray.split(" ");
		for (int index = 0; index < numbersString.length; index++) {
			numbers[index] = Integer.parseInt(numbersString[index]);
		}
		int resultBestIndex = bestIndex(numbers);
		System.out.println(resultBestIndex);
	}
	public static void testDry() {
//		int[] numbers = new int[]{2, 1, 3, 9, 2, 4, -10, -9, 1, 3};
		int[] numbers = new int[]{-3, 2, 3, -4, 3, 1};
		int resultBestIndex = bestIndex(numbers);
		
		System.out.println("Amount Numbers: " + numbers.length);
		System.out.println("Numbers: " + Arrays.toString(numbers));
		System.out.println("Best Index: " + resultBestIndex);
		
//		System.out.println("test sumAmountOfElements: " + sumAmountOfElements(numbers, 0, 0, 0));
//		System.out.println("test specialSum: " + specialSum(numbers, 0, 1, 0, 0));
	}
}

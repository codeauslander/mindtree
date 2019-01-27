package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
  
  public static int LinearSearchRecursively(int[] numbers, int number, int currentIndex) {
    int numbersLength = numbers.length;
		if (currentIndex < numbersLength) {
      int currentNumber = numbers[currentIndex];
      System.out.println("currentNumber: " + currentNumber + " currentIndex: " + currentIndex);
      if (currentNumber == number) {
        return currentIndex; 
      }
      return LinearSearchRecursively(numbers, number, currentIndex + 1);
    } 
    return -1;
  }
  
	public static void main(String[] argh) {
		testHardCode();
	}

	public static void testUserInput() {
		System.out.println("Enter numbers. ");
		Scanner userInput = new Scanner(System.in);
		String numberList = userInput.nextLine();
		System.out.println("Enter the number You want to look for. ");
		int number = userInput.nextInt();

		String[] integerStrings = numberList.split(" ");
		int[] numbers = new int[integerStrings.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(integerStrings[i]);
    }
    
		int resultBinarySearch = LinearSearchRecursively(numbers, number, 0);
		System.out.println("Linear search: " + resultBinarySearch);
		userInput.close();
	}

	public static void testHardCode() {
		System.out.println("Binary search.");
		System.out.println();
		int[] numbers = { 1, 2, 3, 4, 5, 10, 100, 202 };
		System.out.println("Sorted numbers: " + Arrays.toString(numbers));
		int numberA = numbers[numbers.length - 2];
		System.out.println("Number to look for: " + numberA);
		int resultBinarySearchA = LinearSearchRecursively(numbers, numberA, 0);
		System.out.println("Binary search result: " + resultBinarySearchA);
		System.out.println();

		System.out.println("Sorted numbers: " + Arrays.toString(numbers));
		int numberB = numbers[5];
		System.out.println("Number to look for: " + numberB);
		int resultBinarySearchB = LinearSearchRecursively(numbers, numberB, 0);
		System.out.println("Binary search result: " + resultBinarySearchB);
		System.out.println();
	}
}

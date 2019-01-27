package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static int binarySearch(int[] sortedNumbers, int number) {
		int sortedNumbersLength = sortedNumbers.length;
		int rigthIndex = sortedNumbersLength - 1;
		int leftIndex = 0;
		int middleIndex, middleNumber;
		while (leftIndex < rigthIndex) {
			middleIndex = (leftIndex + rigthIndex) / 2;
			middleNumber = sortedNumbers[middleIndex];
			System.out.println("Indices Left: " + leftIndex + " Right: " + rigthIndex + " Middle: " + middleIndex);
			System.out.println("middleNumber: " + middleNumber + " number: " + number);
			System.out.println();

			if (middleNumber > number) {
				rigthIndex = middleIndex;
			} else if (middleNumber < number) {
				leftIndex = middleIndex;
			} else {
				return middleIndex;
			}
		}
		return -1;
  }
  
  public static int binarySearchRecursively(int[] sortedNumbers, int number, int leftIndex, int rigthIndex) {
		int middleIndex, middleNumber;
		if (leftIndex < rigthIndex) {
			middleIndex = (leftIndex + rigthIndex) / 2;
			middleNumber = sortedNumbers[middleIndex];
			System.out.println("Indices Left: " + leftIndex + " Right: " + rigthIndex + " Middle: " + middleIndex);
			System.out.println("middleNumber: " + middleNumber + " number: " + number);
			System.out.println();

			if (middleNumber > number) {
        return binarySearchRecursively(sortedNumbers, number, leftIndex, middleIndex);
			} else if (middleNumber < number) {
        return binarySearchRecursively(sortedNumbers, number, middleIndex, rigthIndex);
			} else {
				return middleIndex;
			}
		}
		return -1;
  }
  
	public static void main(String[] argh) {
		testHardCode();
	}

	public static void testUserInput() {
		System.out.println("Enter a sorted array separeted by spaces. ");
		Scanner userInput = new Scanner(System.in);
		String numberList = userInput.nextLine();
		System.out.println("Enter the number You want to look for. ");
		int number = userInput.nextInt();

		String[] integerStrings = numberList.split(" ");
		int[] sortedNumbers = new int[integerStrings.length];
		for (int i = 0; i < sortedNumbers.length; i++) {
			sortedNumbers[i] = Integer.parseInt(integerStrings[i]);
		}
		int resultBinarySearch = binarySearch(sortedNumbers, number);
		System.out.println("Binary search result: " + resultBinarySearch);
		userInput.close();
	}

	public static void testHardCode() {
		System.out.println("Binary search.");
		System.out.println();
		int[] sortedNumbers = { 1, 2, 3, 4, 5, 10, 100, 202 };
		System.out.println("Sorted numbers: " + Arrays.toString(sortedNumbers));
		int numberA = sortedNumbers[sortedNumbers.length - 2];
		System.out.println("Number to look for: " + numberA);
		int resultBinarySearchA = binarySearch(sortedNumbers, numberA);
		System.out.println("Binary search result: " + resultBinarySearchA);
		System.out.println();

		System.out.println("Sorted numbers: " + Arrays.toString(sortedNumbers));
		int numberB = sortedNumbers[5];
		System.out.println("Number to look for: " + numberB);
		int resultBinarySearchB = binarySearchRecursively(sortedNumbers, numberB, 0, sortedNumbers.length - 1);
		System.out.println("Binary search result: " + resultBinarySearchB);
		System.out.println();
	}
}

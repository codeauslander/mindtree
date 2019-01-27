package Class;

import java.util.Arrays;

public class ArrayQuestions {
//	Hi team,
//	These are the following questions.Please use methods to solve these questions

//	1.	Write a Java program to calculate the average value of array elements
//	2.	Write a Java program to test if an array contains a specific value
//	3.	Write a Java program to remove a specific element from an array
//	4.	Write a Java program to insert an element (specific position) into an array
//	5.	Write a Java program to find the maximum and minimum value of an array

	public static int sum(int[] numbers) {
		int resultSum = 0;
		int numbersLength = numbers.length;
		for (int index = 0; index < numbersLength; index++) {
			resultSum += numbers[index];
		}
		return resultSum;
	}
	public static double average(int[] numbers) {
		int numbersLength = numbers.length;
		double resultAverage = (sum(numbers) / numbersLength);
		return resultAverage;
	}
	public static int indexNumber(int[] numbers, int number) {
		int numbersLength = numbers.length;
		for (int index = 0; index < numbersLength; index++) {
			int currentNumber = numbers[index];
			if (currentNumber == number) {
				return index;
			}
		}
		return -1;
	}
	public static int[] removeNumberByIndex(int[] numbers, int startIndex) {
		int numbersLength = numbers.length - 1;
		int[] resultNumbers = new int[numbersLength];
		int numbersIndex = 0;
		for (int index = 0; index < numbersLength; index++) {
			if (startIndex == numbersIndex) {
				numbersIndex++;
			}
			resultNumbers[index] = numbers[numbersIndex];
			numbersIndex++;
		}
		return resultNumbers;
	}
	public static int[] removeNumber(int[] numbers, int number) {
		int numberIndex = indexNumber(numbers, number);
		if (numberIndex == -1) {
			return null;
		}
		int[] resultNumbers = removeNumberByIndex(numbers, numberIndex);
		return resultNumbers;
	}
	public static int[] insertNumberAtIndex(int[] numbers, int startIndex, int number) {
		int numbersLength = numbers.length;
		int[] resultNumbers = new int[numbersLength + 1];
		int currentIndex = startIndex + 1;
		for (int index = 0; index < startIndex; index++) {
			resultNumbers[index] = numbers[index];
		}
		resultNumbers[startIndex] = number;
		for (int index = startIndex; index < numbersLength; index++) {
			resultNumbers[index + 1] = numbers[index];
		}
		return resultNumbers;
	}
	public static int[] maximumAndMinimum(int[] numbers) {
		int maximum = numbers[0];
		int minimum = numbers[0];
		int[] resultMaximumAndMinimum = new int[2];
		int numbersLength = numbers.length;
		for (int index = 0; index < numbersLength; index++) {
			int number = numbers[index];
			if (number > maximum) {
				maximum = number;
			}
			if (number < minimum) {
				minimum = number;
			}
		}
		resultMaximumAndMinimum[0] = maximum;
		resultMaximumAndMinimum[1] = minimum;
		return resultMaximumAndMinimum;
	}
	public static void main(String[] args) {
		testDRY();
	}
	public static void testDRY() {
		int[] numbers = { 500, 600, 400, 150, 200 };
		String printNumbers = Arrays.toString(numbers);
		System.out.println("Numbers: " + printNumbers);
		
		System.out.println();
		System.out.println("1. Write a Java program to calculate the average value of array elements");
		System.out.println("Numbers: " + Arrays.toString(numbers));
		double resultAverage = average(numbers);
		System.out.println("Average: " + resultAverage);
		System.out.println();

		System.out.println("2. Write a Java program to test if an array contains a specific value");
		System.out.println("Numbers: " + Arrays.toString(numbers));
		int numberA = 150;
		System.out.println("Number: " + numberA);
		int indexNumber = indexNumber(numbers, numberA);
		System.out.println("Index of Number: " + indexNumber);
		System.out.println();

		System.out.println("3. Write a Java program to remove a specific element from an array");
		System.out.println("Number: " + numberA + " being removed from numbers: " + Arrays.toString(numbers));
		int[] resultRemoveNumber = removeNumber(numbers, numberA);
		System.out.println("Result numbers: " + Arrays.toString(resultRemoveNumber));
		System.out.println();

		System.out.println("4. Write a Java program to insert an element (specific position) into an array");
		int startIndex = 1;
		System.out.println("Number: " + numberA + " being inserted at index: " + startIndex + " to numbers: " + Arrays.toString(numbers));
		int[] resultInsertNumberAtIndex = insertNumberAtIndex(numbers, startIndex, numberA);
		System.out.println("Result numbers: " + Arrays.toString(resultInsertNumberAtIndex));
		System.out.println();

		System.out.println("5. Write a Java program to find the maximum and minimum value of an array");
		System.out.println("Finding the maximum and minimum in numbers: " + Arrays.toString(numbers));
		int[] resultMaximumAndMinimum = maximumAndMinimum(numbers);
		System.out.println("Maximum number: " + resultMaximumAndMinimum[0] + " Minimum number: " + resultMaximumAndMinimum[1]);
	}

}

package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	
	public static int[] swap(int[] numbers, int leftIndex, int rightIndex) {
		System.out.println("in swap : " + Arrays.toString(numbers) + " " + leftIndex + " " + rightIndex);
		int temporaryNumber = numbers[leftIndex];
		numbers[leftIndex] = numbers[rightIndex];
		numbers[rightIndex] = temporaryNumber;
		System.out.println("out swap: " + Arrays.toString(numbers));
		System.out.println();
		return numbers;
	}
	public static int[] selectionSort(int[] numbers) {
		int numbersLength = numbers.length;
		for (int outerIndex = 0; outerIndex < numbersLength - 1; outerIndex++) {
			int minimumNumberIndex = outerIndex;
			for (int innerIndex = outerIndex + 1; innerIndex < numbersLength; innerIndex++) {
				if (numbers[innerIndex] < numbers[minimumNumberIndex]) {
					minimumNumberIndex = innerIndex;
				}
			}
			if (minimumNumberIndex != outerIndex) {
				numbers = swap(numbers, outerIndex, minimumNumberIndex);
			}
		}
		return numbers;
	}

	public static void main(String[] args) {
		testHardCode();
	}
	public static void testUserInput() {
		System.out.println("Enter an un sorted array separeted by spaces.");
        Scanner userInput = new Scanner(System.in);
        String numberList = userInput.nextLine();
        
        String[] integerStrings = numberList.split(" "); 
        int[] numbers = new int[integerStrings.length]; 
	    for (int i = 0; i < numbers.length; i++){
	    	numbers[i] = Integer.parseInt(integerStrings[i]); 
	    }
	    numbers = selectionSort(numbers);
       System.out.println(Arrays.toString(numbers));
       userInput.close();
	}
	public static void testHardCode() {
		System.out.println("Selection sort.");
		int[] numbers = {3, 56, 2, 101, 1};
		System.out.println("Numbers: " + Arrays.toString(numbers));
		System.out.println();
		int[] resultSelectionSort = selectionSort(numbers);
		System.out.println("Sorted : " + Arrays.toString(resultSelectionSort));
	}

}

package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	
	public static int[] swap(int[] numbers, int leftIndex, int rightIndex) {
		System.out.println("in swap : " + Arrays.toString(numbers) + " " + leftIndex + " " + rightIndex);
		int temporaryNumber = numbers[leftIndex];
		numbers[leftIndex] = numbers[rightIndex];
		numbers[rightIndex] = temporaryNumber;
		System.out.println("out swap: " + Arrays.toString(numbers));
		System.out.println();
		return numbers;
	}
	public static int[] insertionSort(int[] numbers) {
		int numbersLength = numbers.length;
		int outerIndex = 0;
		while (outerIndex < numbersLength) {
			int innerIndex = outerIndex;
			while (innerIndex > 0 && numbers[innerIndex - 1] > numbers[innerIndex]) {
				numbers = swap(numbers, innerIndex - 1, innerIndex);
				innerIndex--;
			}
			outerIndex++;
		}
		return numbers;
	}
	public static int[] insertionSortRecursevely(int[] numbers, int index) {
		if (index > 0) {
      // System.out.println("numbers: " + Arrays.toString(numbers) + " index: " + index);
			insertionSortRecursevely(numbers, index - 1);
			int rigthNumber = numbers[index];
			int leftIndex = index - 1;
			while (leftIndex >= 0 && numbers[leftIndex] > rigthNumber) {
        // numbers[leftIndex + 1] = numbers[leftIndex];
        numbers = swap(numbers, leftIndex, leftIndex + 1);
				leftIndex--;
			}
			// numbers[leftIndex + 1] = rigthNumber;
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
	    numbers = insertionSort(numbers);
       System.out.println(Arrays.toString(numbers));
       userInput.close();
	}
	public static void testHardCode() {
		System.out.println("Insertion sort.");
		// int[] numbers = {3, 56, 2, 101, 11};
		int[] numbers = {3, 56, 2, 101, 1};
		System.out.println("Numbers: " + Arrays.toString(numbers));
		System.out.println();
		int[] resultInsertionSort = insertionSort(numbers);
		System.out.println("Sorted : " + Arrays.toString(resultInsertionSort));
		System.out.println();
    
    System.out.println("Insertion sort recursevely.");
		int[] numbers2 = {3, 56, 2, 101, 1};
		System.out.println("Numbers: " + Arrays.toString(numbers2));
		System.out.println();
		int[] resultInsertionSortRecursevely =insertionSortRecursevely(numbers2, numbers2.length - 1);
		System.out.println("Sorted : " + Arrays.toString(resultInsertionSortRecursevely));
	}
}

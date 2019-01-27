package Algorithms;
import java.util.Scanner;
public class BubbleSort {
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

	public static void main(String []argh){
		testDry();
    }
	public static void testDry() {
		System.out.println("Sort characters");
	}
}

// Assignment 2
package Jan19_Pre_Orchard_Challenge;

import java.util.Arrays;
import java.util.Scanner;

public class A_2_BubbleSort {
	public static int[] simpleSort(int[] numbers) {
		int outerAmountNumbers = numbers.length;
        int innerAmountNumbers = outerAmountNumbers - 1;
        for(int leftIndex = 0; leftIndex < innerAmountNumbers; leftIndex++) {
        	for (int rightIndex = leftIndex + 1; rightIndex < outerAmountNumbers; rightIndex++) {
        		int leftNumber = numbers[leftIndex];
        		int rightNumber = numbers[rightIndex];
				if(leftNumber > rightNumber) {
					int temporaryNumber = leftNumber;
					numbers[leftIndex] = rightNumber;
					numbers[rightIndex] = temporaryNumber;
				}
			}
        }
        return numbers;
	}
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
//		int newNumbersLength = 0;
		boolean swapped = false;
		do {
//			newNumbersLength = 0;
		     swapped = false;
		     for (int index = 1; index < numbersLength; index++) {
				if (numbers[index - 1] > numbers[index]) {
					numbers = swap(numbers, index - 1, index);
					swapped = true;
//					newNumbersLength = index;
				}
			}
//		     numbersLength = newNumbersLength;
		     numbersLength--;
//		} while (numbersLength <= 1);
		} while (swapped);
        return numbers;
	}
	public static void main(String []argh){
		System.out.println("Enter an un sorted array separeted by spaces.");
        Scanner userInput = new Scanner(System.in);
//        String numberList = user`	Input.nextLine();
        String numberList = "1 3 5 6 2 4 6";
        
        String[] integerStrings = numberList.split(" "); 
        int[] numbers = new int[integerStrings.length]; 
	    for (int i = 0; i < numbers.length; i++){
	    	numbers[i] = Integer.parseInt(integerStrings[i]); 
	    }
//	    numbers = simpleSort(numbers);
	    numbers = bubbleSort(numbers);
       System.out.println(Arrays.toString(numbers));
       userInput.close();
    }
}

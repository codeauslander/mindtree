package Jan19_Basecamp_HackerEarth;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeCost {
	public static int minimumCost(int[] numbers, boolean[] movedNumbers, int startCost, int currentCost, int currentIndex) {
		int numbersLength = numbers.length;
		int nextIndex = currentIndex + 1;
		boolean movedNumber = movedNumbers[currentIndex];
		if (nextIndex < numbersLength && !movedNumber) {
			if (currentCost < 1) {
				minimumCost(numbers, movedNumbers, startCost, currentCost, currentIndex);
			}
			int number = numbers[currentIndex];
			int nextNumber = numbers[nextIndex];
			int ajustment = number + nextNumber;
			numbers[currentIndex] = 0;
			numbers[nextIndex] = ajustment;
			movedNumbers[currentIndex] = true;
			if (ajustment > 0) {
				minimumCost(numbers, movedNumbers, startCost, currentCost, currentIndex);
			}
		}
		System.out.println("Moved: " + Arrays.toString(numbers));
		return numbers[currentIndex];
	}
	public static void main(String[] args) {
//		testUserInput();
		testDry();
	}
	public static void testUserInput() {
		Scanner inputUser = new Scanner(System.in);
		int numbersLength = inputUser.nextInt();
		int cost = inputUser.nextInt();
		String stringNumbers = inputUser.nextLine();
		String[] stringArrayNumbers = stringNumbers.split(" "); 
        int[] numbers = new int[numbersLength];
	    for (int i = 0; i < numbers.length; i++){
	    	numbers[i] = Integer.parseInt(stringArrayNumbers[i]); 
	    }
	    
	    int resultMinimumCost = minimumCost(numbers, new boolean[numbers.length], cost, cost, 0);
	    System.out.println(resultMinimumCost);
	}
	public static void testDry() {
		int cost = 2;
		int[] numbers = {3, -1, -2};
		int[] originalNumbers = Arrays.copyOf(numbers, numbers.length);
		int result = 0;
		
		int resultMinimumCost = minimumCost(numbers, new boolean[numbers.length], cost, cost, 0);
		
		System.out.println("Input numbers: " + Arrays.toString(originalNumbers) + " cost: " + cost);
		System.out.println("Output cost:   " + resultMinimumCost);
		System.out.println("Should be:     " + result);
		System.out.println("Test pass:     " + (result == resultMinimumCost));
	}
}

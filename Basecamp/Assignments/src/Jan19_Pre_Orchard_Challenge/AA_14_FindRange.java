package Jan19_Pre_Orchard_Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AA_14_FindRange {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int number = userInput.nextInt();
		int exit = 0;
		while(number != exit) {
			numbers.add(number);
			number = userInput.nextInt();
		}
		String result = Arrays.toString(maximumMinimumNumber(numbers));
		System.out.println(result);
	}

	public static int[] maximumMinimumNumber(ArrayList<Integer> numbers) {
		int[] result = new int[2];
		int maximum = Integer.MIN_VALUE;
		int minimum = Integer.MAX_VALUE;
		int number;
		int index = numbers.size();
		while(index-- > 0) {
			number = numbers.get(index);
			if(number > maximum) {
				maximum = number;
			}
			if(number < minimum) {   
				minimum = number;
			}
		}
		result[0] = maximum;
		result[1] = minimum;
		return result;
	}

}

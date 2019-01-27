package Jan19_Pre_Orchard_Challenge;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class A_9_Triplets {
	public static void main(String []args){
//	    Scanner userInput = new Scanner(System.in);
//	    String numberList = userInput.nextLine();
//	    userInput.close();
//      String[] integerStrings = numberList.split(" "); 
//      int[] numbers = new int[integerStrings.length]; 
//	    for (int i = 0; i < numbers.length; i++){
//	    	numbers[i] = Integer.parseInt(integerStrings[i]); 
//	    }
//		printTriplets(numbersGroupA);
	    
	    int[] numbersGroupA = {2,3,4,5,7} ;
	    int[] numbersGroupB = {1,2,3,4,5,7,9};
	    printTriplets(numbersGroupA);
	    System.out.println();
	    printTriplets(numbersGroupB);
	}
	public static void printTriplets(int[] numbers) {
		
		int amountNumbers = numbers.length;
		int indexRight = amountNumbers;
		ArrayList<String> triplets = new ArrayList<String>();
		while (indexRight-- > 0) {
			int indexMiddle = amountNumbers;
			while (indexMiddle-- > 0) {
				int indexLeft = amountNumbers;
				while (indexLeft-- > 0) {
					if (indexRight != indexMiddle && indexLeft != indexMiddle && indexRight != indexLeft) {
						int numberRight = numbers[indexRight];
						int numberMiddle = numbers[indexMiddle];
						int numberLeft = numbers[indexLeft];
						if ((numberLeft + numberMiddle) == numberRight) {
							String triplet = numberLeft + " + " + numberMiddle + " = " + numberRight 
									+ " " + "<" + numberLeft + "," + numberMiddle + "," + numberRight + ">";
							triplets.add(triplet);
						}
					}
				}
			}
		}
		int index = triplets.size();
		while(index-- > 0) {
			System.out.println(triplets.get(index));
		}
	}
}

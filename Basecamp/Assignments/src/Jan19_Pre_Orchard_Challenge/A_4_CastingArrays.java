package Jan19_Pre_Orchard_Challenge;

import java.util.Arrays;
import java.util.Scanner;

public class A_4_CastingArrays {
	public static void main(String []args){
		System.out.println("Running");
	    Scanner userInput = new Scanner(System.in);
	    
	    String numberList = userInput.nextLine();
	    String[] integerStrings = numberList.split(" "); 
	    int firstNumbersLength = integerStrings.length;
	    double[] firstNumbers = new double[firstNumbersLength]; 
	    for (int index = 0; index < firstNumbersLength; index++){
	    	firstNumbers[index] = Double.parseDouble(integerStrings[index]); 
	    }
	    
	    numberList = userInput.nextLine();
	    integerStrings = numberList.split(" "); 
	    int secondNumbersLength = integerStrings.length;
	    double[] secondNumbers = new double[secondNumbersLength]; 
	    for (int index = 0; index < secondNumbersLength; index++){
	    	secondNumbers[index] = Double.parseDouble(integerStrings[index]); 
	    }
	    
	    int summedNumbersLength;
	    int smallLength;
	    if(firstNumbersLength > secondNumbersLength) {
	    	summedNumbersLength = firstNumbersLength;
	    	smallLength = secondNumbersLength;
	    } else {
	    	summedNumbersLength = secondNumbersLength;
	    	smallLength = firstNumbersLength;
	    }
	    
	    int[] summedNumbers = new int[summedNumbersLength];
	    for (int index = 0; index < smallLength; index++) {
	    	summedNumbers[index] += (int) Math.round((firstNumbers[index] + secondNumbers[index]));
		}
	    
	    if(firstNumbersLength > secondNumbersLength) {
	    	for (int index = smallLength; index < summedNumbersLength; index++) {
		    	summedNumbers[index] += (int) firstNumbers[index];
			}
	    } else {
	    	for (int index = smallLength; index < summedNumbersLength; index++) {
		    	summedNumbers[index] += (int) secondNumbers[index];
			}
	    }
	    
	    System.out.println(Arrays.toString(summedNumbers));
	    userInput.close();
    }
}

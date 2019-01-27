// Assignment 1
package Jan19_Pre_Orchard_Challenge;
import java.util.*;
public class A_1_Hailstone {
	public static void main(String []argh){
        Scanner userInput = new Scanner(System.in);
        int number = userInput.nextInt();
        int steps = 0;
        while(number > 1) {
        	steps ++;
        	if(number % 2 == 0) {
        		int halfNumber = number / 2;
        		System.out.println(number + " is even so I take half: " + halfNumber);
        		number = halfNumber;
        	} else {
        		int multipliedNumber = (number * 3) + 1;
				System.out.println(number + " is odd so I make 3n+1: " + multipliedNumber);
				number = multipliedNumber;
			}
        }
//        missing bubble sort
        System.out.println("There are total " + steps + " steps to reach 1");
        userInput.close();
    }
}



package ShotClass;

import java.util.ArrayList;
import java.util.List;

public class C2_MaximumDifferenceInAnArray {
	
	public static int maxDifference(List<Integer> numbers) {
        // Write your code here
        int numbersLength = numbers.size();
        int maximum = 0;
        int minimum = 0;
        int operation = 0;
        for (int index = 1; index < numbersLength; index++) {
            int number = numbers.get(index);
            if (numbers.get(index - 1) < minimum && operation > maximum) {
				minimum = numbers.get(index - 1);
				operation = number - minimum;
				if (operation > maximum) {
					maximum = operation;
				}
			} else {
				int count = index;
				while(count-- > 0) {
	                if (numbers.get(count) < numbers.get(index)) {
	                    operation = numbers.get(index) - numbers.get(count);
	                    if(operation > maximum){
	                        maximum = operation;
	                    }
	                    System.out.println(maximum);
	                }
	            }
			}
        }
        return maximum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		System.out.println(maxDifference(numbers));
	}

}

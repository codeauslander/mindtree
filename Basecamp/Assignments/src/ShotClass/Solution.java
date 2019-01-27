package ShotClass;

import java.util.*;

public class Solution {
	
//	 public static List<Integer> getTimes(List<Integer> time, List<Integer> direction) {
//    // Write your code here
//        int peopleAmount = direction.size();
//        int indexPeople = 0;
//        int[][] people = new int[peopleAmount][2];
//        ArrayList<Integer> priority = new ArrayList<Integer>();
//        List<Integer> peopleWillPass = new ArrayList<Integer>();
//        while(indexPeople < peopleAmount){
//        	people[indexPeople][0] = time.indexOf(indexPeople);
//        	people[indexPeople][1] = direction.indexOf(indexPeople);
//        	indexPeople++;
//        }
//        for (int index = 0; index < peopleAmount - 1; index++) {
//        	if ((people[index][0] < people[index + 1][0]) || (people[index][1] > people[index + 1][1])) {
//				priority.add(index);
//			} else {
//				priority.add(index + 1);
//			}
//		}
//        for (int index = 0; index < peopleAmount; index++) {
//        	peopleWillPass.set(priority.get(index), people[index][0] + people[index][1]);
//		}
//        return Arrays.asList(peopleWillPass);
//    }
	
//	 public static String fizzBuzz(int n) {
//		 for (int number = 1; number <= n; number++) {
//			 System.out.print(number % 15 == 0 ? "FizzBuzz" : number % 5 == 0 ? "Buzz" : number % 3 == 0 ? "Fizz" : number);
//		}
//	 }
	
    public static String chageCharacter(String text, int index) {
        if(index < text.length()){
//        	System.out.println(text + " " + index + (index + 1));
            return text.substring(0, index) + ' ' + text.substring(index + 1);
        }
        return text;
     }
     public static String isBalance(String value) {
    	 HashMap<Character,Character> dictionary = new HashMap<Character, Character>();
         dictionary.put('{','}');
         dictionary.put('[',']');
         dictionary.put('(',')');
         String isBalance = "YES";
         if (value.length() % 2 != 0) {
             isBalance = "NO";
         } 
         else {
        	 System.out.println(value);
            for (int outerIndex = 0; outerIndex < value.length(); outerIndex++) {
                char character = value.charAt(outerIndex);
                for (int innerIndex = value.length() - 1; innerIndex > outerIndex ; innerIndex--) {
                	char nextCharacter = value.charAt(innerIndex);
                    if (dictionary.get(character) != null && dictionary.get(character) == nextCharacter) {
                        value = chageCharacter(value, outerIndex);
//                        System.out.println(value);
                        value = chageCharacter(value, innerIndex);
                        character = value.charAt(outerIndex + 1);
                        System.out.println(value);
                        if (value.trim().length() % 2 != 0) {
                        	System.out.println(value + "_No");
                            isBalance = "NO";
                        }
//                        outerIndex++;
                    }
                    
                }
                
            }
            System.out.println("value" + value.trim());
             
            if (value.trim().length() != 0) {
                isBalance = "NO";
            }
        }
        return isBalance;
     }
     public static String[] braces(String[] values) {
         int valuesLength = values.length;
         String[] results = new String[valuesLength];
         for (int index = 0; index < valuesLength; index++) {
            results[index] = isBalance(values[index]);
         }
         return results;
     }
	 public static void main(String args[]) {
//		 System.out.println(isBalance("{}[]()"));
//		 System.out.println(isBalance("{[()]}"));
//		 System.out.println(isBalance("{[(])}"));
		 System.out.println(isBalance("{{[[(())]]}}"));
	 }
	 
	
}

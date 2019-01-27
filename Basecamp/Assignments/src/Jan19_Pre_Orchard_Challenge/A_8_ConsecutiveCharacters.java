package Jan19_Pre_Orchard_Challenge;
import java.util.*;
import java.util.Scanner;

public class A_8_ConsecutiveCharacters {
	public static HashMap consecutiveCharacters(String sentence) {
		sentence = sentence.replaceAll("[^a-zA-Z0-9 ]", "").toUpperCase();
		int pairOne;
		HashMap<String, Integer> pairs = new HashMap<String, Integer>();
		for(int index = 0; index < sentence.length() - 1; index++) {
			char leftLetter = sentence.charAt(index);
			char rigthLetter = sentence.charAt(index + 1);
			if(leftLetter == ' ' || rigthLetter == ' ') {
				continue;
			}
			pairOne = leftLetter + rigthLetter;
			int counter = 0;
			int pairTwo;
			for(int indexPairTwo = 0; indexPairTwo < sentence.length() - 1; indexPairTwo++) {
				pairTwo = sentence.charAt(indexPairTwo) + sentence.charAt(indexPairTwo+1);
				if( pairOne == pairTwo) {
					counter++;
				}
			}
			if(counter > 0) {
				pairs.put(sentence.charAt(index)+""+sentence.charAt(index+1),counter);
			}
		}
		return pairs;
	}
	public static void main(String []args){
	    Scanner userInput = new Scanner(System.in);
	    String inputOne = "saw a CD play-er and a\r\n" + 
	    		"modem in ccd";
	    String inputTwo = "Student List do not exist\r\n" + 
	    		"in sys-tem";
	    printHashMap(consecutiveCharacters(inputTwo));
	    userInput.close();
	}
	public static void printHashMap(HashMap hashMap) {
		Set keys = hashMap.keySet();
		for (Object name:  keys){
            String key = name.toString();
            String value = ""+hashMap.get(name);  
            System.out.println(key + ":" + value);  
	    }
	}

}

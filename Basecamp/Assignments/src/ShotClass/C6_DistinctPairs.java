package ShotClass;

import java.util.*;

public class C6_DistinctPairs {
	public static int numberOfPairs(List<Integer> numbers, long target) {
        // Write your code here
        int counter = 0;
//        ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
        
        for (int outerIndex = 0; outerIndex < numbers.size(); outerIndex++) {
            boolean check = true;
            for (int innerIndex = outerIndex + 1; innerIndex < numbers.size(); innerIndex++) {
                if(check){
                    if (numbers.get(outerIndex) == numbers.get(innerIndex)) {
                    	check = false;
//                    ArrayList<Integer> pair = new ArrayList<Integer>();
//                    pair.add(numbers.get(outerIndex));
//                    pair.add(numbers.get(outerIndex));
//                    pairs.add(pair);
                    if (numbers.get(outerIndex) + numbers.get(innerIndex) == target) {
                        System.out.println(numbers.get(outerIndex) + "," + numbers.get(innerIndex));
                        counter++;
                    }
                    numbers.remove(innerIndex);
                } else {
                    if (numbers.get(outerIndex) + numbers.get(innerIndex) == target) {
                        System.out.println(numbers.get(outerIndex) + "," + numbers.get(innerIndex));
                        counter++;
                    }
//                    ArrayList<Integer> pair = new ArrayList<Integer>();
//                    pair.add(numbers.get(outerIndex));
//                    pair.add(numbers.get(innerIndex));
//                    System.out.println(pair.toString());
//                    pairs.add(pair);
                }
                }
                
            }
            
        }
//        System.out.println(numbers.toString());
//        for (int outerIndex = 0; outerIndex < numbers.size(); outerIndex++) {
//            ArrayList<Integer> pair = new ArrayList<Integer>();
//            
//            for (int innerIndex = outerIndex + 1; innerIndex < numbers.size(); innerIndex++) {
//                pair.add(numbers.get(outerIndex));
//                pair.add(numbers.get(innerIndex));
//                System.out.println(pair.toString());
//                pairs.add(pair);
//                pair = new ArrayList<Integer>();
//            }
//            
//        }
//        for (int index = 0; index < pairs.size(); index++) {
//            long sum = pairs.get(index).get(0) + pairs.get(index).get(1);
//            if (sum == target) {
//                counter ++;
//            }
//        }
        return counter;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

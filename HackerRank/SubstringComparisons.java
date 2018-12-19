// https://www.hackerrank.com/challenges/java-string-compare/problem

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        smallest = s.substring(0, k);
        largest = s.substring(0, k);
        String auxSmallest = "";
        String auxLargest = "";
        for(int i = 1; i < s.length() - (k - 1); i ++){
            auxSmallest = s.substring(i, i + k);
            auxLargest = s.substring(i, i + k);
            // System.out.println(smallest);
            // System.out.println(auxSmallest);
            if(smallest.compareTo(auxSmallest) > 0){
                smallest = auxSmallest;
            }
            if (auxLargest.compareTo(largest) > 0) {
                largest = auxLargest;
            }
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}


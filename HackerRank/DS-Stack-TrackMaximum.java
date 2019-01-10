// https://www.hackerrank.com/challenges/maximum-element/problem
// Maximum Element

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int amountQueries = input.nextInt();
        Stack<Integer> stackNumbers = new Stack<Integer>();
        Stack<Integer> stackTrackPeek = new Stack<Integer>();
        // stackTrackPeek.push(Integer.MIN_VALUE);
        while(amountQueries-- > 0){
            int typeQuery = input.nextInt();
            switch(typeQuery){
                case 1:
                    int value = input.nextInt();
                    stackNumbers.push(value);
                    if(stackTrackPeek.isEmpty() || value >= stackTrackPeek.peek()){
                        stackTrackPeek.push(value);
                    } 
                    break;
                case 2:
                    int deletedNumber = stackNumbers.pop();
                    if(stackTrackPeek.peek() == deletedNumber){
                        stackTrackPeek.pop();
                    }
                    break;
                case 3:
                    System.out.println(stackTrackPeek.peek());
                    break;
            }
        }
        input.close();
    }
}

// https://www.hackerrank.com/challenges/java-string-reverse/problem

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String reverse = "";
        for(int i = A.length() - 1; i >= 0; i --){
            reverse = reverse + A.charAt(i);
        }
        System.out.println( 
            A.compareTo(reverse) == 0 ? "Yes" : "No"
        );
    }
}
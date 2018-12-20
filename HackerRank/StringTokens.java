// https://www.hackerrank.com/challenges/java-string-tokens/problem
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        scan.close();
        if( s.length() == 0){
            System.out.println(s.length());
            return;
        }
        String[] tokens = s.split("[^A-Za-z]+");
        System.out.println(tokens.length);
        for(String token : tokens){
            System.out.println(token);
        }
    }
}


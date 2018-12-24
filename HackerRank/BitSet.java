// https://www.hackerrank.com/challenges/java-bitset/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        for(int position = 0; position < M; position++){
            String operator = scanner.next();
            int operandOne = scanner.nextInt();
            int operandTwo = scanner.nextInt();
            BitSet b1;
            BitSet b2;
            if(operandOne == 1) { b1 = B1; }
            else{ b1 = B2; }
            if ( operator.equals("AND") || 
                 operator.equals("OR") || 
                 operator.equals("XOR")) {
                    if (operandTwo == 1) { b2 = B2; } 
                    else { b2 = B1; }
                    if (operator.equals("AND"))
                        b1.and(b2);
                    else if (operator.equals("OR"))
                        b1.or(b2);
                    else if (operator.equals("XOR"))
                        b1.xor(b2);             
            } else {
                if (operator.equals("SET"))
                    b1.set(operandTwo);
                else if (operator.equals("FLIP"))
                    b1.flip(operandTwo);
            }
            System.out.println(String.format("%d %d", B1.cardinality(), B2.cardinality()));
        }
        scanner.close();
    }
}


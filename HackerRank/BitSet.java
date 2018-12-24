// https://www.hackerrank.com/challenges/java-bitset/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Map<Integer, BitSet> bitSets = new HashMap<Integer, BitSet>();
        for (int i = 0; i < 2; i++) {
            bitSets.put(i+1, new BitSet(N));
        }
        for (int i = 0; i < M; i++) {
            String operation = scanner.next();
            int leftBitSet = scanner.nextInt();
            int rightBitSet = scanner.nextInt();
            if (operation.equals("AND")) {
                bitSets.get(leftBitSet).and(bitSets.get(rightBitSet));
            } else if (operation.equals("OR")) {
                bitSets.get(leftBitSet).or(bitSets.get(rightBitSet));
            } else if (operation.equals("XOR")) {
                bitSets.get(leftBitSet).xor(bitSets.get(rightBitSet));
            } else if (operation.equals("FLIP")) {
                bitSets.get(leftBitSet).flip(rightBitSet);
            } else if (operation.equals("SET")) {
                bitSets.get(leftBitSet).set(rightBitSet);
            }
            System.out.println(bitSets.get(1).cardinality() + " " + bitSets.get(2).cardinality());
        }
        scanner.close();
    }
}




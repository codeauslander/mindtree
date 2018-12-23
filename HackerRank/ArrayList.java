// https://www.hackerrank.com/challenges/java-arraylist/problem

import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int amount = scanner.nextInt();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        for(int line = 0; line < amount; line++){
            int numbers = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int index = 0; index < numbers; index++) {
               list.add(scanner.nextInt());
            }
            arrayList.add(list);
        }
        int amountQueries = scanner.nextInt();
        for(int query = 0; query < amountQueries; query++){
            try{
                System.out.println(
                    arrayList.get(scanner.nextInt() - 1).get(scanner.nextInt() - 1)
                );
            }catch(IndexOutOfBoundsException error){
                System.out.println("ERROR!");
            }
        }   
        scanner.close();
    }
}


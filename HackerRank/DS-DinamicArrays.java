// https://www.hackerrank.com/challenges/dynamic-array/problem
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int lastAnswer = 0;
        int sequences = scanner.nextInt();
        int queries = scanner.nextInt();
        int type, x, y, index;
        ArrayList<Integer>[] seqList = new ArrayList[sequences];
        while(queries-->0){
            type = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            index = (x ^ lastAnswer) % sequences;
            switch(type){
                case 1:
                    if(seqList[index] == null){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(y);
                        seqList[index] = list;
                    } else {
                        seqList[index].add(y);
                    }
                    break;
                case 2:
                    lastAnswer = seqList[index].get(y % seqList[index].size());
                    System.out.println(lastAnswer);
                    break;
            }
        }
        scanner.close();
    }
}
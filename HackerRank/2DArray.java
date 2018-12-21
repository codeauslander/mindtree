// https://www.hackerrank.com/challenges/java-2d-array/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        final int height = arr.length;

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        final int higthHourglass = (height / 2);
        int maximumHourglass = Integer.MIN_VALUE;
        for(int row = 0; row <= higthHourglass; row++ ){
          for(int position = 0; position <= higthHourglass; position++){
            final int top = arr[row][position] + arr[row][position + 1] + arr[row][position + 2];
            final int middle = arr[row + 1][position + 1];
            final int bottom = arr[row + 2][position] + arr[row + 2][position + 1] + arr[row + 2][position + 2];
            final int hourglass = top + middle + bottom ;
            if(hourglass > maximumHourglass){
              maximumHourglass = hourglass;
            }
          }
        }
        
        System.out.println(maximumHourglass);
        scanner.close();
    }
}

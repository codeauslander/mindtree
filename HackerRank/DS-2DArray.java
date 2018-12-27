// https://www.hackerrank.com/challenges/2d-array/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        final int hourglassType = 3;
        final int rows = arr.length - hourglassType;
        final int columns = arr[0].length - hourglassType;
        int maximumHourglass = Integer.MIN_VALUE;
        for(int row = 0; row <= rows; row++){
            for(int column = 0; column <= columns; column++){
                final int top = arr[row][column] +
                                arr[row][column + 1] +
                                arr[row][column + 2];
                final int middle = arr[row + 1][column + 1];
                final int bottom = arr[row + 2][column] + 
                                   arr[row + 2][column + 1] + 
                                   arr[row + 2][column + 2];
                final int hourglass = top +  middle + bottom;
                System.out.println(top + "|" + middle + "|" + bottom + "=" + hourglass);
                if(hourglass > maximumHourglass){
                    maximumHourglass = hourglass;
                }
            }
        }
        return maximumHourglass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

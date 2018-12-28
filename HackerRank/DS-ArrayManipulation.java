// https://www.hackerrank.com/challenges/crush/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        
        long maximum = Long.MIN_VALUE;
        int sizeQueries = queries.length;
        // int sizeNumbers = Integer.MIN_VALUE;
        int sizeNumbers = n;
        
        // for(int indexQueries = 0; indexQueries < sizeQueries; indexQueries++){
        //     if(queries[indexQueries][1] > sizeNumbers)
        //         sizeNumbers = queries[indexQueries][1];
        // }

        long[] numbers = new long[sizeNumbers];

        for(int indexQueries = 0; indexQueries < sizeQueries; indexQueries++){
            int a = queries[indexQueries][0] - 1;
            int b = queries[indexQueries][1];
            int k = queries[indexQueries][2];
            // for(int indexNumbers = a; indexNumbers < b; indexNumbers++){
            //     numbers[indexNumbers] += k;
            //     if (numbers[indexNumbers] > maximum)
            //         maximum = numbers[indexNumbers];
            // }
            numbers[a] += k;
            if (b < n ) {
                numbers[b] -= k;
            }
            // if (numbers[a] > maximum)
            //         maximum = numbers[a];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            maximum = Math.max(maximum, sum);
        }
        return maximum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        // long[] numbers = new long[n];
        // long maximum = Long.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
            
            // int a = Integer.parseInt(queriesRowItems[0]) - 1;
            // int b = Integer.parseInt(queriesRowItems[1]);
            // int k = Integer.parseInt(queriesRowItems[2]);
            // for(int indexNumbers = a; indexNumbers < b; indexNumbers++){
            //     numbers[indexNumbers] += k;
            //     if (numbers[indexNumbers] > maximum)
            //         maximum = numbers[indexNumbers];
            // }
        }

        long result = arrayManipulation(n, queries);
        // long result = maximum;

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

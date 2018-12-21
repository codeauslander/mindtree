import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        int[] array = new int[amount];
        int count = 0;
        final int length = array.length;
        for(int position = 0; position < length; position++){
            final int value = scan.nextInt();
            array[position] = value;
        }
        for (int group = 0; group < amount; group++) {
            int sum = 0;
            for (int position = group; position < amount; position++) {
                sum += array[position];
                if( sum < 0){
                    count++;
                }
            }
        }
        
        System.out.println(count);
        
        
    }
}


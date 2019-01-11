// https://www.hackerrank.com/challenges/equal-stacks/problem
// Equal Stacks
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        System.out.print(
            Arrays.toString(h1) + "," 
            + Arrays.toString(h2) 
            + "," + Arrays.toString(h3)
        );
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Stack<Integer> stack3 = new Stack<Integer>();
        int sumStack1 = 0;
        int sumStack2 = 0;
        int sumStack3 = 0;
        int minimumHight;
        for(int index = h1.length - 1; index > -1; index--){
            int value = h1[index];
            stack1.push(value);
            sumStack1 += value;
        }
        for (int index = h2.length - 1; index > -1; index--) {
            int value = h2[index];
            stack2.push(value);
            sumStack2 += value;
        }
        for (int index = h3.length - 1; index > -1; index--) {
            int value = h3[index];
            stack3.push(value);
            sumStack3 += value;
        }
        // System.out.print(sumStack1 + "," + sumStack2 + "," + sumStack3);
        while(!(
            sumStack1 == sumStack2 && 
            sumStack1 == sumStack3 && 
            sumStack2 == sumStack3 )
        ){
            // System.out.print(sumStack1 + "," + sumStack2 + "," + sumStack3);
            if(
                sumStack1 >= sumStack2 && 
                sumStack1 >= sumStack3
            ){
                sumStack1 -= stack1.pop();
            }else if(
                (sumStack2 >= sumStack1) &&
                (sumStack2 >= sumStack3)
            ){
                sumStack2 -= stack2.pop();
            }else {
                sumStack3 -= stack3.pop();
            }       
            // System.out.print(sumStack1 + "," + sumStack2 + "," + sumStack3);
        }
        System.out.println(sumStack1 + "|" + sumStack2 + "|" + sumStack3);
        return sumStack1;
    }
// }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class Solution { 
    static int mixTwoCookies(int aCookie, int bCookie){
        return aCookie + 2 * bCookie;
    }
    static boolean sweetEnough(int sweetness, int cookie){
        if(cookie < sweetness){
            return false;
        }
        return true;
    }
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> sortCookies = new PriorityQueue<Integer>();
        for(int item : A){
            sortCookies.add(item);
        }
        int counter = 0;
        while(!sweetEnough(k, sortCookies.peek()) && sortCookies.size() > 1){
            int cookie = mixTwoCookies(sortCookies.poll(), sortCookies.poll());
            sortCookies.add(cookie);
            counter++;
        }
        if(sweetEnough(k, sortCookies.peek())){
            return counter;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

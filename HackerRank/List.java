// https://www.hackerrank.com/challenges/java-list/problem
import java.io.*;
import java.util.*;

public class Solution {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int amount = scanner.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int position = 0; position < amount; position++){
            list.add(position, scanner.nextInt());
        }
        int queries = scanner.nextInt();
        for(int line = 0; line < queries; line++){
            String query = scanner.next().trim();
            if(query.equals("Insert")){
                list.add(scanner.nextInt(), scanner.nextInt());
            }else if(query.equals("Delete")){
                list.remove(scanner.nextInt());
            }
        }
        System.out.println(
            list.toString().replace("[","").replace("]","").replace(",","")
        );
    }
}


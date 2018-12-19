import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(s);
        String[] tokens = s.split("[A-Za-z !,?._'@]+");
        System.out.println(tokens.length);
        for(String token : tokens){
            System.out.println(token);
        }
        scan.close();
    }
}


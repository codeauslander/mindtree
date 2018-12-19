// https://www.hackerrank.com/challenges/java-anagrams/problem

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String A, String B) {
        // Complete the function
        char[] a = A.toLowerCase().toCharArray();
        char[] b = B.toLowerCase().toCharArray();
        if (a.length != b.length) {
            return false;
        }
        final int CHARS = 500;
        int[] aChars = new int[CHARS];
        int[] bChars = new int[CHARS];
        int max = a.length;
        for (int i = 0; i < max ; i++) {
            aChars[a[i]]++;
            bChars[b[i]]++;
        }
        for (int i = 0; i < CHARS; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean isAnagram2(String A, String B) {
      // Complete the function
      char[] a = A.toLowerCase().toCharArray();
      char[] b = B.toLowerCase().toCharArray();
      int aLength = a.length;
      int bLength = b.length;
      if( aLength != bLength){
        return false;
      }
      Arrays.sort(a);
      Arrays.sort(b);
      for (int i = 0; i < aLength; i++) {
        if (a[i] != b[i]) {
          return false;
        }
      }
      return true;
  }





    static boolean isAnagram(String A, String B) {
      // Complete the function
      char[] a = A.toLowerCase().toCharArray();
      char[] b = B.toLowerCase().toCharArray();
      if (a.length != b.length) {
          return false;
      }
      final int CHARS = 500;
      int[] aChars = new int[CHARS];
      int[] bChars = new int[CHARS];
      int max = a.length;
      for (int i = 0; i < max ; i++) {
          aChars[a[i]]++;
          bChars[b[i]]++;
      }
      for (int i = 0; i < CHARS; i++) {
          if (aChars[i] != bChars[i]) {
              return false;
          }
      }
      return true;
  }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

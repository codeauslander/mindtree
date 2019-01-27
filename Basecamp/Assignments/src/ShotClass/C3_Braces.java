package ShotClass;

import java.util.HashMap;

public class C3_Braces {
	
	public static boolean isBalance(String text) {
		System.out.println("text: " + text);
        String reducedString = text.replaceAll("[^\\[\\]{}()]", "");
        System.out.println("Removing lonely pairs: " + reducedString);
        while (reducedString.contains("{}") || reducedString.contains("[]") || reducedString.contains("()")) {
        	reducedString = reducedString.replaceAll("\\(\\)|\\{}|\\[]", "");
        	System.out.println("Removing inside pairs: " + reducedString);
        }
        return reducedString.length() == 0;
    }

	public static void main(String[] args) {
//		System.out.println(isBalance("{{[[((())]]}}()"));
		System.out.println(isBalance("{[hey]}(ni)"));
	}
}
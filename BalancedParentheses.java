// Java Stack
// https://www.hackerrank.com/challenges/java-stack/problem

import java.util.*;
// import java.util.Stack;

class Solution{
    public static char[][] TOKENS = { {'(',')'}, {'[',']'}, {'{','}'} };

    public static boolean isOpen(char character){
        for(char[] pair : TOKENS){
            if(pair[0] == character){
                return true;
            }
        }
        return false;
    }

    public static boolean matches(char openCharacter, char closeCharacter){
        for(char[] pair : TOKENS){
            if(pair[0] == openCharacter && pair[1] == closeCharacter){
                return true;
            }
        }
        return false;
    }

    public static boolean isBalanced (String expression){
        Stack<Character> section = new Stack<Character>();
        for(char character : expression.toCharArray()){
            if(isOpen(character)){
                section.push(character);
            }else{
                if( section.isEmpty()){
                    return false;
                }
                char last = section.pop();
                if(!matches(last, character)){
                    return false;
                }
            }
        }
        return section.isEmpty();
    }
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
		}
		
	}
}




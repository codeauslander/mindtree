// https://www.hackerrank.com/challenges/phone-book/problem

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        Map<String,Integer> contacts = new HashMap<String,Integer>();
		int n=in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
            contacts.put(name, phone);
			in.nextLine();
            
		}
        // System.out.println(contacts);
		while(in.hasNext())
		{
			String s=in.nextLine();
            if(contacts.get(s) != null){

                System.out.println(s + "=" + contacts.get(s));
            } else{
                System.out.println("Not found");
            }
		}
	}
}




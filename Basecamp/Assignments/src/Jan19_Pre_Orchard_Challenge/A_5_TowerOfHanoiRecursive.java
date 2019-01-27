package Jan19_Pre_Orchard_Challenge;

import java.util.Arrays;
import java.util.Scanner;

public class A_5_TowerOfHanoiRecursive {
	public static void main(String []args){
	    Scanner userInput = new Scanner(System.in);
	    String startPole = "A", endPole = "C", temporaryPole = "B";
	    int disks = 3;
//	    disks = userInput.nextInt();
//	    startPole = userInput.next();
//	    endPole = userInput.next();
	    userInput.close();
	    int steps = moveDisks(disks, startPole, endPole, temporaryPole);
	    System.out.println("Number of steps for " + disks + " disks: " + steps);
//	    System.out.println();
//	    towerOfHanoi(disks, startPole, endPole, temporaryPole);   
	}
	public static int moveDisks(int disks, String startPole, String endPole, String temporaryPole) {
		int steps = 0;
		if(disks > 0) {
			steps = moveDisks(disks - 1, startPole, temporaryPole, endPole);
			System.out.println("Move disk #"  +disks + " from pole " + startPole + " to pole " + endPole);
			steps ++;
			steps += moveDisks(disks - 1, temporaryPole, endPole, startPole);
		}
		return steps;
	}
	public static void towerOfHanoi(int disks, String startPole, String endPole, String temporaryPole) {
		if(disks == 1) {
			System.out.println("Mode disk 1 from pole " + startPole + " to pole " + endPole);
			return;
		}
		towerOfHanoi(disks - 1, startPole, temporaryPole, endPole);
		System.out.println("Move disk " + disks + " from pole " + startPole + " to pole " + endPole);
		towerOfHanoi(disks - 1, temporaryPole, endPole, startPole);
	}
}

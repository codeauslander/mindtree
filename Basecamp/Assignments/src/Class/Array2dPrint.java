package Class;
import java.io.IOException;
import java.util.Scanner;
public class Array2dPrint {
	public static void print2DArray(int[][] array2d) {
		int outerLength = array2d.length;
		String matrix = "";
		for (int outerIndex = 0; outerIndex < outerLength; outerIndex++) {
			int innerLength = array2d[outerIndex].length;
			String row = "";
			for (int innerIndex = 0; innerIndex < innerLength; innerIndex++) {
				row += array2d[outerIndex][innerIndex] + ",";
			}
			matrix +=  row + "\n";
			row = "";
		}
		System.out.println(matrix);
	}
	public static int[][] addMatrices(int[][] leftMatrix, int[][] rightMatrix) {
		int rows = leftMatrix.length;
		int columns = leftMatrix[0].length;
		int[][] sumMatrix = new int[rows][columns];
		for (int outerIndex = 0; outerIndex < rows; outerIndex++) {
			for (int innerIndex = 0; innerIndex < columns; innerIndex++) {
				int number = leftMatrix[outerIndex][innerIndex] + rightMatrix[outerIndex][innerIndex];
				sumMatrix[outerIndex][innerIndex] = number;
			}
		}
		return sumMatrix;
	}
	public static int[][] convertStringMatrixToInteger(String stringMatrix){
		String[] outerArray = stringMatrix.trim().split(",");
		int[][] array2d = new int[outerArray.length][];
		for (int index = 0; index < outerArray.length; index++) {
			String[] innerArray = outerArray[index].trim().split(" ");
			int[] column = new int[innerArray.length];
			for (int innerIndex = 0; innerIndex < column.length; innerIndex++) {
				column[innerIndex] = Integer.parseInt(innerArray[innerIndex]);
			}
			array2d[index] = column;
		}
		return array2d;
	}
	public static int sumEvenNumbers(int[][] matrix) {
		int sumEven = 0;
		for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
			for (int innerIndex = 0; innerIndex < matrix.length; innerIndex++) {
				int number = matrix[outerIndex][innerIndex];
				if (number % 2 == 0) {
					sumEven += number;
				}
			}
		}
		return sumEven;
	}
	public static int sumOddNumbers(int[][] matrix) {
		int sumOdd = 0;
		for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
			for (int innerIndex = 0; innerIndex < matrix.length; innerIndex++) {
				int number = matrix[outerIndex][innerIndex];
				if (number % 2 != 0) {
					sumOdd += number;
				}
			}
		}
		return sumOdd;
	}
	public static int maximumNumber(int first, int second) {
		return first > second ? first : second;
	}
	public static void main(String[] args) {
		consoleInterface();
//		testUserInput();
//		testDry();
	}
	public static void consoleInterface() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome welcome, come, come.");
		System.out.println("Enter a 2d array like this 1 0 1, 0 1 0, 1 1 1");
		System.out.println("Or like this 1 0 1, 2 7 0, 12 1 1");
		System.out.println();
		System.out.println("Enter left matrix");
		String stringLeftMatrix = scanner.nextLine();
		int[][] leftMatrix = convertStringMatrixToInteger(stringLeftMatrix);
		System.out.println();
		System.out.println("Enter right matrix");
		String stringRightMatrix = scanner.nextLine();
		int[][] rightMatrix = convertStringMatrixToInteger(stringRightMatrix);
		int[][] resultAddMatrices = addMatrices(leftMatrix, rightMatrix);
		int resultSumEvenNumbers = sumEvenNumbers(resultAddMatrices);
		int resultSumOddNumbers = sumOddNumbers(resultAddMatrices);
		System.out.println();
		
		String space = "\n";
		String menu = "0. Print left matrix." + space +
					  "1. Print right matrix." + space +
					  "2. Sum left and right matrix." + space +
					  "3. Calculate sum of even numbers in result matrix." + space +
					  "4. Calculate sum of even numbers in result matrix." + space +
					  "5. Maximum number between even sum and odd sum." + space;
//		System.out.println(menu);
		int  option = -1;
		
		while(option != 9) {
//			try {
//				Runtime.getRuntime().exec("cls");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("Please enter an option.");
			System.out.println(menu);
			option = scanner.nextInt();
			switch (option) {
			case 0:
				System.out.println("Left matrix:");
				print2DArray(leftMatrix);
				break;
			case 1:
				System.out.println("Right matrix:");
				print2DArray(rightMatrix);
				break;
			case 2:
				System.out.println("Here is the sum");
				print2DArray(resultAddMatrices);
				break;
			case 3:
				System.out.println("Sum of the even numbers in the result matrix");
				System.out.println("Sum even: " + resultSumEvenNumbers);
				System.out.println();
				break;
			case 4:
				System.out.println("Sum of the odd numbers in the result matrix");
				System.out.println("Sum odd: " + resultSumOddNumbers);
				System.out.println();
				break;
			case 5:
				System.out.println("Maximum number between even sum and odd sum.");
				int maximum = maximumNumber(resultSumEvenNumbers, resultSumOddNumbers);
				System.out.println("Maximum number: " + maximum);
				System.out.println();
			default:
				System.out.println("Please enter an option or q to quit.");
				break;
			}
		}
		scanner.close();
	}
	public static void testUserInput() {
//		add the even numbers and odd numbers compare maximum
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a 2d array like this 1 0 1, 0 1 0, 1 1 1 or  1 0 1, 2 7 0, 12 1 1");
//		String userInput = scanner.nextLine();
//		int[][] array2d = convertStringMatrixToInteger(userInput);
//		System.out.println("Here is the array 2d you enter");
//		print2DArray(array2d);
		
		System.out.println("Enter left matrix");
		String stringLeftMatrix = scanner.nextLine();
		int[][] leftMatrix = convertStringMatrixToInteger(stringLeftMatrix);
		
		System.out.println("Enter right matrix");
		String stringRightMatrix = scanner.nextLine();
		int[][] rightMatrix = convertStringMatrixToInteger(stringRightMatrix);
		
		System.out.println("Here is the sum");
		int[][] resultAddMatrices = addMatrices(leftMatrix, rightMatrix);
		print2DArray(resultAddMatrices);
		
		System.out.println("Sum of the even numbers");
		int[][] matrix = resultAddMatrices;
		int resultSumEvenNumbers = sumEvenNumbers(matrix);
		System.out.println("Sum even: " + resultSumEvenNumbers);
		System.out.println();
		
		System.out.println("Sum of the odd numbers in the result matrix");
//		int[][] matrix = resultAddMatrices;
		int resultSumOddNumbers = sumOddNumbers(matrix);
		System.out.println("Sum odd: " + resultSumOddNumbers);
		System.out.println();
		
		System.out.println("Maximum number between even sum and odd sum.");
//		int[][] matrix = resultAddMatrices;
		int maximum = maximumNumber(resultSumEvenNumbers, resultSumOddNumbers);
		System.out.println("Maximum number: " + maximum);
		System.out.println();
		
		
		scanner.close();
	}
	public static void testDry() {
//		Monica
		System.out.println("Initial matrix.");
		int[][] array2d = {{6,0,1},{4,1,0},{1,1,1}};
		print2DArray(array2d);
		
		System.out.println("Add two matrices");
		System.out.println("Left matrix:");
		int[][] leftMatrix = array2d;
		print2DArray(leftMatrix);
		
		System.out.println("Right matrix");
		int[][] rightMatrix = {{1,0,2},{0,1,5},{1,1,9}};
		print2DArray(rightMatrix);
		
		int[][] resultAddMatrices = addMatrices(leftMatrix, rightMatrix);
		System.out.println("Result matrix");
		print2DArray(resultAddMatrices);
		
		System.out.println("Sum of the even numbers in the result matrix");
		int[][] matrix = resultAddMatrices;
		int resultSumEvenNumbers = sumEvenNumbers(matrix);
		System.out.println("Sum even: " + resultSumEvenNumbers);
		System.out.println();
		
		System.out.println("Sum of the odd numbers in the result matrix");
//		int[][] matrix = resultAddMatrices;
		int resultSumOddNumbers = sumOddNumbers(matrix);
		System.out.println("Sum odd: " + resultSumOddNumbers);
		System.out.println();
		
		System.out.println("Maximum number between even sum and odd sum.");
//		int[][] matrix = resultAddMatrices;
		int maximum = maximumNumber(resultSumEvenNumbers, resultSumOddNumbers);
		System.out.println("Maximum number: " + maximum);
		System.out.println();
	}
}
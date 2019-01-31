package Algorithms;

import java.util.*;

public class QuickSort{
  public static int[] swap(int[] numbers, int leftIndex, int rightIndex) {
		int leftNumber = numbers[leftIndex];
		int rightNumber = numbers[rightIndex];
		int temporaryNumber = leftNumber;
		
		numbers[leftIndex] = rightNumber;
		numbers[rightIndex] = temporaryNumber;
		
		return numbers;
	}
  public static int partition(int[] numbers, int l, int h){
    int pivot = numbers[h];
    int i = l, j = l;
    while (j < h - 1) {
      if (numbers[j] < pivot) {
        swap(numbers, i, j);
        i = i + 1;
      }
    }
    swap(numbers, i, h);
    return i;
  }
  public static int[] quickSort(int[] numbers, int lower, int higther){
    if (lower < higther) {
      int j = partition(numbers, lower, higther);
      quickSort(numbers, lower, j);
      quickSort(numbers, j + 1, higther);
    } 
    return numbers;
  }
  public static void main(String[] args) {
    testHarcoded();
  }
  public static void testHarcoded(){
    System.out.println("QuickSort");
    int[] numbers = {9, 6, 3, 2, 100, 200, 250, -1};
    System.out.println("Numbers: " + Arrays.toString(numbers));
    int[] resultQuickSort = quickSort(numbers, 0, numbers.length - 1);
    System.out.println("Result QuickSort: " + Arrays.toString(resultQuickSort));
  }
}
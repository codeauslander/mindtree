package Class;
import java.util.*;
public class ArrayGames{
  public static int sumArray(int[] numbers) {
    int numbersLength = numbers.length;
    int sum = 0;
    for (int index = 0; index < numbersLength; index++) {
      sum += numbers[index];
    }
    return sum;
  }
  public static int sumArrayRecursevely(int[] numbers, int index, int sum){
    if (index < numbers.length) {
      return sumArrayRecursevely(numbers, index + 1, sum + numbers[index]);
    }
    return sum;
  }
  public static double[] sumArrayIntegersAndFloats(int[] numberIntegers, float[] numberFloats){
    int firstNumbersLength = numberIntegers.length;
    int secondNumbersLength = numberFloats.length;    
    int summedNumbersLength;
    int smallLength;
    if(firstNumbersLength > secondNumbersLength) {
      summedNumbersLength = firstNumbersLength;
      smallLength = secondNumbersLength;
    } else {
      summedNumbersLength = secondNumbersLength;
      smallLength = firstNumbersLength;
    }
    double[] summedNumbers = new double[summedNumbersLength];
    for (int index = 0; index < smallLength; index++) {
      // summedNumbers[index] += Math.round(numberIntegers[index] + numberFloats[index]);
      summedNumbers[index] += numberIntegers[index] + numberFloats[index];
    }
    if(firstNumbersLength > secondNumbersLength) {
      for (int index = smallLength; index < summedNumbersLength; index++) {
        summedNumbers[index] += numberIntegers[index];
      }
    } else {
      for (int index = smallLength; index < summedNumbersLength; index++) {
        summedNumbers[index] += numberFloats[index];
      }
    }
    return summedNumbers;
  }
  public static void main(String[] args) {
    System.out.println("Array Game");
    System.out.println();
    testHardCode();
  }
  public static void testHardCode() {
    testSumArray();
    testSumArrayIntegersAndFloats();
  }
  public static void testSumArray(){
    System.out.println("Sum Array values");
    int[] numbers = {9, 6, 3, 2, 100, 200, 250, -1};
    System.out.println("Numbers: " + Arrays.toString(numbers));
    int resultSumArray = sumArray(numbers);
    System.out.println("Sum: " + resultSumArray);
    System.out.println();

    System.out.println("Sum Array values Recursevely");
    System.out.println("Numbers: " + Arrays.toString(numbers));
    int resultSumArrayRecursevely = sumArrayRecursevely(numbers, 0, 0);
    System.out.println("Sum: " + resultSumArrayRecursevely);
    System.out.println();    
  }
  public static void testSumArrayIntegersAndFloats(){
    System.out.println("Sum Array of Integers with Array of Floats");
    int[] numbers = {9, 6, 3, 2, 100, 200, 250, -1};
    System.out.println("Integer Numbers: " + Arrays.toString(numbers));
    float[] floatNumbers = {1.4f, 2.5f, 3.0f, 7.9f, 5.9f};
    System.out.println("Float Numbers: " + Arrays.toString(floatNumbers));
    double[] resultSumArrayIntegersAndFloats = sumArrayIntegersAndFloats(numbers, floatNumbers);
    System.out.println("Sum Array: " + Arrays.toString(resultSumArrayIntegersAndFloats));
  }
}
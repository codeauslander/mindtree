package ShotClass;

public class C9_FizzBuzz {

	public static void fizzBuzz(int n) {
        for (int number = 1; number <= n; number++) {
            String jump = "\n";
            String value = (number % 15 == 0 ? "FizzBuzz" : number % 5 == 0 ? "Buzz" : number % 3 == 0 ? "Fizz" : number+"");
            System.out.print(value+jump);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

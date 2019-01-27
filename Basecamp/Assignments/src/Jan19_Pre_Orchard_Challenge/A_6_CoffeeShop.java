package Jan19_Pre_Orchard_Challenge;
import java.util.Scanner;
public class A_6_CoffeeShop {
	static int MAXIMUM_RAITING = 5;
	public static A_6_Customer[] createCustomers(int amountCustomer) {
		A_6_Customer[] customers = new A_6_Customer[amountCustomer];
		while(amountCustomer-- > 0) {
			customers[amountCustomer] = new A_6_Customer("fakeName"+amountCustomer,"fakeMobiler"+amountCustomer,Math.random()*MAXIMUM_RAITING);
		}
		return customers;
	}
	public static A_6_Customer[] addCustomer(A_6_Customer[] customers, String name, String mobileNumber, double raiting) {
		int amountCustomers = customers.length + 1;
		A_6_Customer[] newCustomers = new A_6_Customer[amountCustomers];
		newCustomers[0] = new A_6_Customer(name, mobileNumber, raiting);
		while (amountCustomers-- > 1) {
			newCustomers[amountCustomers] = customers[amountCustomers - 1];
		}
		return newCustomers;
	}
	public static void main(String []args){
	    Scanner userInput = new Scanner(System.in);
//	    int amountCustomers = 5;
	    System.out.println("Amount of Customers you want at the begining.");
	    System.out.print("Number: ");
	    int amountCustomers = userInput.nextInt();
	    A_6_Customer[] customers = createCustomers(amountCustomers);
	    printCustomers(customers);
	    System.out.println();
	    System.out.println("Hello, Welcome to Bubury Coffee Shop.");
	    String inputInformation = "";
	    while(!inputInformation.equals("q")) {
	    	System.out.println("Use q to quit the program.");
			System.out.println("Please enter your customer information separated by commas. Name, Mobile Number, Raiting");
			System.out.print("Customer: ");
			inputInformation = userInput.nextLine();
			
			String[] information = inputInformation.split(",");
			if (information.length == 3) {
				String name = information[0];
				String mobileNumber = information[1];
				double raiting = Double.parseDouble(information[2]);
				
				customers = addCustomer(customers, name, mobileNumber, raiting);
			}
	    }
		System.out.println("Thank You!");
		System.out.println("Here are the costumer you added");
		System.out.println();
		printCustomers(customers);
	    userInput.close();
	}
	public static void printCustomers(A_6_Customer[] customers) {
		int amountCustomers = customers.length, counter = amountCustomers;
		for (int index = 0; index < amountCustomers; index++) {
			A_6_Customer customer = customers[index];
			customer.getPrettyFeedbackRating();
			System.out.println(counter + "# Customer: " + customer.getName() + " gave a rating of  " + customer.getPrettyFeedbackRating() + " out of " + MAXIMUM_RAITING + " Moble number: " + customer.getMobileNumber());
			counter--;
		}
	}
}

package Jan19_Pre_Orchard_Challenge;

public class AA_10_Organization {
	public static AA_10_Employee[] createEmployees(int amount) {
		AA_10_Employee[] employees = new AA_10_Employee[amount];
		while(amount-- > 0) {
			employees[amount] = new AA_10_Employee(amount, ""+amount, ""+amount, ""+amount);
		}
		return employees;
	}
	public static void main(String[] args) {
		AA_10_Employee[] employees = createEmployees(5);
		AA_10_Employee employee = employees[0];
		try {
//			employee.setName(null);
			employee.setName(" ");
			employee.setDesignation("no a designation");
			employee.setDeparment("no a deparment");
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDesignationException e) {
			System.out.println(e.getMessage());
		} catch (InvalidDepartmentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}

package Jan19_Pre_Orchard_Challenge;

import java.util.Arrays;

public class AA_10_Employee {
	int id;
	String name, designation, deparment;
	String[] DESIGNATIONS = { "developer", "tester", "lead", "manager" };
	String[] DEPARTMENTS = { "C2", "TTG", "ITES", "PES" };
	public AA_10_Employee(int id, String name, String designation, String deparment){
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.deparment = deparment;
	}
	public String getDeparment() {
		return deparment;
	}

	public String getDesignation() {
		return designation;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDeparment(String deparment) throws InvalidDepartmentException {
		int index = DEPARTMENTS.length;
		int counter = 0;
		while(index-- > 0) {
			if(DEPARTMENTS[index].equals(deparment)) {
				counter++;
			}
		}
		if(counter == 0) {
			throw new InvalidDepartmentException("Deparment has to be one of " + Arrays.toString(DEPARTMENTS));			
		} else {
			this.deparment = deparment;
		}
	}

	public void setDesignation(String designation) throws InvalidDesignationException {
		int index = DESIGNATIONS.length;
		int counter = 0;
		while(index-- > 0) {
			if(DESIGNATIONS[index].equals(designation)) {
				counter++;
			}
		}
		if(counter == 0) {
			throw new InvalidDesignationException("Designation has to be one of " + Arrays.toString(DESIGNATIONS));
		} else {
			this.designation = designation;
		}
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		if(name == null || name.replaceAll("\\s+","").equals("")) {
			throw new NullPointerException("Name can not be null or blank."); 
		} else {
			this.name = name;
		}
	}

	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", deparment=" + deparment
				+ "]";
	}
}

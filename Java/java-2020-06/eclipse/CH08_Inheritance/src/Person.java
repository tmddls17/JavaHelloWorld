
public class Person {
	public String name;
	public double annual_salary;
	public int hire_date;
	public String SSN;

	public Person() {
		name = "No name yet";
	}

	public Person(String initialName) {
		name = initialName;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Salary: " + annual_salary);
		System.out.println("Hire date: " + hire_date);
		System.out.println("SSN: " + SSN);
	}

	public boolean hasSameName(Person otherPerson) {
		return this.name.equalsIgnoreCase(otherPerson.name);
	}
}

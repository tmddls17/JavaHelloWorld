public class Person{
	protected String name;

	public Person() {
		name = "No name yet";
	}

	public Person(String initialName) {
		name = initialName;
	}

	public String getName() {
		return name;
	}

	public void writeOutput() {
		System.out.println("Name: " + name);
	}
}
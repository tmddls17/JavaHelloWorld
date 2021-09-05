public class CH06a_Pet {
	private String name;
	private int age; //in years
	private double weight;//in pounds
	public CH06a_Pet(String initialName, int initialAge, double initialWeight){
		name = initialName;
		if ((initialAge < 0) || (initialWeight < 0)){
		System.out.println("Error: Negative age or weight.");
		}
		else{
		age = initialAge;
		weight = initialWeight;
		}
	}
	public String getName() {return name;}
	public int getAge() {return age;}
	public double getWeight() {return weight;}
	public void writeOutput(){
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("Weight: " + weight + " pounds");
	}
	public CH06a_Pet() {
		name = "No name yet";
		age = 0;
		weight = 0.0;
	}
	public CH06a_Pet(String initialName) {
		name = initialName;
		age = 0;
		weight = 0.0;
	}
	public CH06a_Pet(int initialAge) {
		name = "No name yet";
		if (initialAge < 0){
			System.out.println("Error: Negative age or weight.");
			}
			else{
			age = initialAge;
			weight = 0;
			}
	}
	public CH06a_Pet(double initialWeight) {
		name = "No name yet";
		if (initialWeight < 0){
			System.out.println("Error: Negative age or weight.");
			}
			else{
			age = 0;
			weight = initialWeight;
			}
	}
public static void main(String[] args) {
CH06a_Pet p;
System.out.println("\nExample 1 - No parameter");
p = new CH06a_Pet(); p.writeOutput();
System.out.println("\nExample 2-1 - Full parameter");
p = new CH06a_Pet("cat",5,2.2); p.writeOutput();
System.out.println("\nExample 2-2 - Negative Age");
p = new CH06a_Pet("cat",-5,2.2); p.writeOutput();
System.out.println("\nExample 2-3 - Negative Weight");
p = new CH06a_Pet("cat",5,-2.2); p.writeOutput();
System.out.println("\nExample 3 - Name parameter");
p = new CH06a_Pet("cat"); p.writeOutput();
System.out.println("\nExample 4-1 - Age parameter");
p = new CH06a_Pet(5); p.writeOutput();
System.out.println("\nExample 4-2 - Negative Age");
p = new CH06a_Pet(-5); p.writeOutput();
System.out.println("\nExample 5-1 - Weight parameter");
p = new CH06a_Pet(2.2); p.writeOutput();
System.out.println("\nExample 5-2 - Negative Weight");
p = new CH06a_Pet(-2.2); p.writeOutput();
}
}
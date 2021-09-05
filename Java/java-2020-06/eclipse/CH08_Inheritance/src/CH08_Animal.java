
public class CH08_Animal implements CH08_Pet {
	protected String name;
	protected String food;
	public String food() {
		return food;
	};
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void getName() {
		System.out.println("Name: " + name);
	}
}


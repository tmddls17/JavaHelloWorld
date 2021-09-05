import java.util.Scanner;

public interface CH08_Pet{
	public void setName(String name);
	public void getName();
	public String food();
	
	public static void main(String[] args) {
		String cat_name, dog_name;
		CH08_Cat cat = new CH08_Cat();
		CH08_Dog dog = new CH08_Dog();
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the cat name and dog name: ");
		cat_name = kb.next();
		dog_name = kb.next();
		cat.setName(cat_name);
		cat.getName();
		feed(cat);
		dog.setName(dog_name);
		dog.getName();
		feed(dog);
		kb.close();
	}

	public static void feed(CH08_Pet pet) {
		System.out.println("feed: " + pet.food());
	}
}

public class CH08_Science extends CH08_Book{
	
	private String publisher;

	CH08_Science(String name_new, String author_new) {
		super(name_new);
		name = name_new;
		publisher = author_new;
	}

	public String toString() {
		String c_name = "Science";
		return c_name;
	}

	public void print() {
		super.print();
		System.out.println("Author: " + publisher);
	}
}

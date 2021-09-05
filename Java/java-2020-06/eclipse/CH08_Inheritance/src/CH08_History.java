
public class CH08_History extends CH08_Book {

	private String author;

	CH08_History(String name_new, String author_new) {
		super(name_new);
		name = name_new;
		author = author_new;
	}

	public String toString() {
		String c_name = "History";
		return c_name;
	}

	public void print() {
		super.print();
		System.out.println("Author: " + author);
	}
}

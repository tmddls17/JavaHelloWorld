
public class CH08_Book {
	protected String name;
	private static  int ID = 0;
	protected int id = 0;
	CH08_Book(String name_new) {
		name = name_new;
		ID++;
		id = ID;
	}

	
	public String toString() {
		String c_name = "BOOK";
		return c_name;
	}
	public void print() {
		System.out.println("<<<" + toString() + ">>>");
		System.out.println("Id: " + id);
		System.out.println("Book Name: " + name);
	}

	public static void main(String[] args) {
		CH08_Book book = new CH08_Book("Simple Book");
		CH08_Science science = new CH08_Science("Hello Physics!", "ScienceWorld"); // Name, Publisher
		CH08_History history1 = new CH08_History("What Is history?", "E.H.Carr"); // Name, Author
		CH08_History history2 = new CH08_History("What Is history? ver 2", "E.H.Carr" );//Name, Author
		book.print();
		science.print();
		history1.print();
		history2.print();
	}
}
public class Student extends Person implements Comparable<Student>{
	private int studentNumber;

	public Student() {
		super();
		studentNumber = 0;// Indicating no number yet
	}

	public Student(String initialName, int initialStudentNumber) {
		super(initialName);
		studentNumber = initialStudentNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int newStudentNumber) {
		studentNumber = newStudentNumber;
	}

	public int compareTo(Student s) {
		return this.studentNumber - s.studentNumber;
	}

	public String toString() {
		return "Name: " + getName() + "\nStudent number: " + studentNumber;
	}
}
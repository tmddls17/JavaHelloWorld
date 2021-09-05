import java.util.Arrays;


public class StudentDemo
{
	public static void main(String[] args)
	{
		Student[] students = new Student[4];

		students[0] = new Student("Fred", 991);
		students[1] = new Student("Bill", 331);
		students[2] = new Student("Adam", 412);
		students[3] = new Student("Chris", 121);

		Arrays.sort(students);

		// Output the sorted array of students
		for (Student s : students)
		{
			System.out.println(s.toString());
		}
	}
}
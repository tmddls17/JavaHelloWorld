public class CH05_PassFail {
	private String name;
	private int score;
	
	public void setdata(String newname, int newscore) {
		name = newname;
		score = newscore;
	}
	public static void identifyOrSameValue(CH05_PassFail a, CH05_PassFail b)	{
		String s1 = a.name;
		String s2 = b.name;
		int n1 = a.score;
		int n2 = b.score;
		if(a == b)	{
			System.out.println("Student1 and Student2 are Same object, Same Hashcode");
		}
		else if(a != b)	{
			System.out.println("Student1 and Student2 are different object, different Hashcode");
		}
		if(s1 == s2 && n1 == n2) {
			System.out.println("Student1 and Student2 have Same state, Same value of instance variable");
		}
		else
			System.out.println("Student1 and Student2 have different value of instance variable");
	}
	public void writeoutput()	{
		System.out.print(name + ": ");
		System.out.print(score + ": ");
		if(score >= 70)
			System.out.println("pass");
		else
			System.out.println("fail");
	}
	public void copyFrom(CH05_PassFail a)	{
		name = a.name;
		score = a.score;
	}
public static void main(String[] args)
{
	System.out.println("Before copying\n");
	String name = "Hongkildong";
	CH05_PassFail student1 = new CH05_PassFail();
	CH05_PassFail student2 = new CH05_PassFail();
	student1.setdata(name, 80);
	student2.setdata("KimChulSoo", 40);
	CH05_PassFail.identifyOrSameValue(student1, student2);
	student1.writeoutput();
	student2.writeoutput();
	System.out.println("Hashcode of student1: " + student1.toString());
	System.out.println("Hashcode of student2: " + student2.toString());
	student1.copyFrom(student2);
	System.out.println("\n\nAfter copying\n");
	CH05_PassFail.identifyOrSameValue(student1, student2);
	student1.writeoutput();
	student2.writeoutput();
	System.out.println("Hashcode of student1: " + student1.toString());
	System.out.println("Hashcode of student2 " + student2.toString());
	System.out.println("\n\nAfter assigning the variable\n");
	student1.setdata("HongKilDong", 80);
	student2.setdata("KimChulSoo", 40);
	student1 = student2;
	CH05_PassFail.identifyOrSameValue(student1, student2);
	student1.writeoutput();
	student2.writeoutput();
	System.out.println("Hashcode of student1: " + student1.toString());
	System.out.println("Hashcode of student2 " + student2.toString());
	}
}

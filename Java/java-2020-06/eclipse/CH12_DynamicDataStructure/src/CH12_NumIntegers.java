import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class CH12_NumIntegers {
	private static HashSet<Integer> set = new HashSet<Integer>();
	CH12_NumIntegers() {

	}

	public static void readdata(String name) {
		try {
			File file = new File(name);
			FileReader filereader = new FileReader(file);
			BufferedReader inFiles = new BufferedReader(filereader);
			String line = "";
			while ((line = inFiles.readLine()) != null) {
				set.add(Integer.parseInt(line));
			}
			filereader.close();
			inFiles.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static int getNumIntegers() {
		int size;
		size = set.size();
		return size;
	}

	public static void printIntegers() {
		ArrayList<Integer> setlist = new ArrayList(set);
		Collections.sort(setlist);
		for(Integer i : setlist) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		String fileName = "C:\\Users\\82109\\Desktop\\ÀÚ¹Ù\\CH12_numbers.txt";
		CH12_NumIntegers NI = new CH12_NumIntegers();
		System.out.println("Reading integers from the file.");
		NI.readdata(fileName);
		System.out.println("Reading Done!");

		System.out.print("\nThe file contains ");
		System.out.println(NI.getNumIntegers() + " differentintegers.\n");
		NI.printIntegers();
	}
}
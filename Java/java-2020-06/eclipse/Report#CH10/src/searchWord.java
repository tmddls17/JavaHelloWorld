import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class searchWord {
	private static String[] searchWord = new String[4]; // searchWordList�� ������ �����ϴ� String �迭
	private static File file1 // searchWordList.txt�� ���ϰ��
	= new File("C:\\Users\\82109\\Desktop\\�ڹ�\\searchWordList.txt");
	private static File file2 // words.txt�� ���ϰ��
	= new File("C:\\Users\\82109\\Desktop\\�ڹ�\\words.txt");
	private static File file3 // result.txt�� ���ϰ��
	= new File("C:\\Users\\82109\\Desktop\\�ڹ�\\result.txt");
	private static int i = 0; // �ݺ����� ���� ����

	public static void getSearchWord() {
		FileReader fileReader = null;// FileReader�� �ʱ� ����
		try {
			fileReader = new FileReader(file1); // �о���� ������ ��θ� ����
			BufferedReader inFiles = new BufferedReader(fileReader);
			// ������ �� �پ� �б� ���� BufferedReader�� ���� 
			String line = "";// �о���� ������ ��� ������ String ����

			while ((line = inFiles.readLine()) != null) { // ������ ������ ������ �� �پ� �о����
				searchWord[i] = line;
				i++;
			}
			// System.out.println("line : "+a);
			inFiles.close();
			fileReader.close(); // ������ �� �о����� ��� FileReader�� BufferedReader�� close����� �Ѵ�.
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(i = 0; i < searchWord.length; i++) {
			searchWord[i] = searchWord[i].replaceAll(" ",""); // ���� searchWord�� ������ �ִٸ� �������ش�.
		}
	}

	public static void write1(String a) {
		FileReader fileReader = null;
		FileWriter fileWriter = null; // FileReader�� FileWriter�� �ʱ⼱��
		try {
			String line = ""; // words.txt���� �о���̴� ���� �����ϴ� String ����
			fileReader = new FileReader(file2);
			fileWriter = new FileWriter(file3, true); 
			// FileReader�� FileWriter�� ���ϰ�θ� �������ش� (�̾ ������ ���̱� ������ FileWriter�� true�� ����)

			BufferedReader inFiles = new BufferedReader(fileReader);
			// words.txt�� �� �پ� �о���̱� ���ؼ� BufferedReader�� �������ش�.
			fileWriter.write("## Word list containing String \"" + a + "\" ##\n");
			// �� searchWord�� ������ ����Ѵ�.
			while ((line = inFiles.readLine()) != null) { // words.txt�� ������ �о����
				if (line.contains(a)) { // �о���� ���� searchWord�� �����ϰ� �ִ� ��� ���� return
					fileWriter.write(line + "\n");
					// �ش��ϴ� �ܾ result.txt�� ���
				}
			}
			fileWriter.write("\n");
			inFiles.close();
			fileReader.close();
			fileWriter.close();
			// ����ξ��� FileReader, FileWriter, BufferedReader�� close ���ش�.
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) {
		getSearchWord();
		for(i = 0; i < searchWord.length; i++) { // �ݺ����� searchWord�� ũ�⸸ŭ ����
			write1(searchWord[i]);
		}
	}
}

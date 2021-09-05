import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class searchWord {
	private static String[] searchWord = new String[4]; // searchWordList의 내용을 저장하는 String 배열
	private static File file1 // searchWordList.txt의 파일경로
	= new File("C:\\Users\\82109\\Desktop\\자바\\searchWordList.txt");
	private static File file2 // words.txt의 파일경로
	= new File("C:\\Users\\82109\\Desktop\\자바\\words.txt");
	private static File file3 // result.txt의 파일경로
	= new File("C:\\Users\\82109\\Desktop\\자바\\result.txt");
	private static int i = 0; // 반복문을 위한 변수

	public static void getSearchWord() {
		FileReader fileReader = null;// FileReader의 초기 선언
		try {
			fileReader = new FileReader(file1); // 읽어들일 파일의 경로를 설정
			BufferedReader inFiles = new BufferedReader(fileReader);
			// 내용을 한 줄씩 읽기 위해 BufferedReader를 선언 
			String line = "";// 읽어들일 내용을 잠시 저장할 String 변수

			while ((line = inFiles.readLine()) != null) { // 파일이 끝나기 전까지 한 줄씩 읽어들임
				searchWord[i] = line;
				i++;
			}
			// System.out.println("line : "+a);
			inFiles.close();
			fileReader.close(); // 파일을 다 읽었으면 모든 FileReader와 BufferedReader를 close해줘야 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(i = 0; i < searchWord.length; i++) {
			searchWord[i] = searchWord[i].replaceAll(" ",""); // 만약 searchWord에 공백이 있다면 제거해준다.
		}
	}

	public static void write1(String a) {
		FileReader fileReader = null;
		FileWriter fileWriter = null; // FileReader와 FileWriter의 초기선언
		try {
			String line = ""; // words.txt에서 읽어들이는 값을 저장하는 String 변수
			fileReader = new FileReader(file2);
			fileWriter = new FileWriter(file3, true); 
			// FileReader와 FileWriter의 파일경로를 설정해준다 (이어서 저장할 것이기 때문에 FileWriter는 true로 설정)

			BufferedReader inFiles = new BufferedReader(fileReader);
			// words.txt를 한 줄씩 읽어들이기 위해서 BufferedReader도 선언해준다.
			fileWriter.write("## Word list containing String \"" + a + "\" ##\n");
			// 각 searchWord의 제목을 출력한다.
			while ((line = inFiles.readLine()) != null) { // words.txt의 끝까지 읽어들임
				if (line.contains(a)) { // 읽어들인 값이 searchWord를 포함하고 있는 경우 참을 return
					fileWriter.write(line + "\n");
					// 해당하는 단어를 result.txt에 출력
				}
			}
			fileWriter.write("\n");
			inFiles.close();
			fileReader.close();
			fileWriter.close();
			// 열어두었던 FileReader, FileWriter, BufferedReader를 close 해준다.
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) {
		getSearchWord();
		for(i = 0; i < searchWord.length; i++) { // 반복문을 searchWord의 크기만큼 실행
			write1(searchWord[i]);
		}
	}
}

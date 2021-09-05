import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CH10_FirstWordRemover {
	static int firstRemover = 0;
	public static void main(String[] args) {
		try {
			// 파일 객체 생성
			File file = new File("C:\\Users\\82109\\Desktop\\자바\\input.txt");
			File file2 = new File("C:\\Users\\82109\\Desktop\\자바\\output.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			FileWriter filewriter = new FileWriter(file2);
			int singleCh = 0;
			for(;(singleCh = filereader.read()) != -1;) {
				if ((char) singleCh == ' ')
					firstRemover = 1;
				if ((char) singleCh == '\n') {
					firstRemover = 0;
					filewriter.write('\n');
				}
				if(firstRemover == 1) {
					filewriter.write(singleCh);
				}
			}
			filewriter.close();
			filereader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

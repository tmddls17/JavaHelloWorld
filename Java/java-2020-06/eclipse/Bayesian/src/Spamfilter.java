import java.io.*;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Spamfilter {
	private static int NumbersSpam; // 스팸 메일의 개수
	private static int NumbersMail; // 전체 메일의 수
	private static float accuracy; // 스팸 메일을 걸러낸 정확도
	private static HashSet<String> spamword = new HashSet<String>(); // 스팸 메일에서 검색된 단어를 저장하는 HashSet (중복 단어 제외)
	private static HashSet<String> nonspamword = new HashSet<String>(); // 일반 메일에서 검색된 단어를 저장하는 HashSet (중복 단어 제외)
	private static String[] spam = new String[200]; // 스팸 메일에서 검색된 단어를 저장하는 배열
	private static String[] nonspam = new String[200]; // 일반 메일과 스팸 메일 모두에서 검색된 단어를 저장하는 배열
	private static int[] repeatinspam = new int[200]; // 스팸메일에서 검색된 각 단어가 총 몇 번 반복되었는지 저장하는 배열
	private static int[] repeatinnonspam = new int[200]; // 일반메일에서 검색된 각 스팸메일과 겹치는 단어가 총 몇 번 반복되었는지 저장하는 배열
	private static int[] repeatinwhole = new int[200]; // 스팸메일에서 검색된 단어가 전체 메일에서 몇 번 반복되는지 저장하는 배열

	public static boolean bayesian_spam_filter(String email, int sizeS) {
		NumbersSpam = 25;
		NumbersMail = 50;
		int i = 0, j = 0;
		String[] Testword = new String[3];
		float[] P_WnSpam = new float[3];
		float Classify = 0;
		int index = 0;
		StringTokenizer tk = new StringTokenizer(email);
		String token;
		token = tk.nextToken("_");
		Testword[0] = token;
		token = tk.nextToken("@");
		token = token.replaceAll("_", "");
		Testword[1] = token;
		token = tk.nextToken(".");
		token = token.replaceAll("@", "");
		Testword[2] = token;
		for (i = 0; i < sizeS; i++) {
			for (j = 0; j < 3; j++) {
				if (Testword[j].equals(spam[i])) {
					float A = (float) repeatinspam[i] / (float) NumbersMail;
					float B = ((float) repeatinwhole[i] / (float) NumbersMail);
					P_WnSpam[index] = A / B;
					System.out.println("P(Spam|" + spam[i] + ") is " + P_WnSpam[index]);
					index++;
				}
			}
		}
		if (index == 0)
			return false;
		else {
			for (i = 0; i < index; i++) {
				if (i == 0) {
					Classify = P_WnSpam[i];
				} else {
					Classify *= P_WnSpam[i];
				}
			}
			if (Classify >= 0.9)
				return true;
		}
		return false;
	}

	public static void repeatwhole(String[] Spam, String[] Nonspam, int sizeS, int sizeN) {
		int i = 0, j = 0;

		for (i = 0; i < sizeS; i++) {
			repeatinwhole[i] = repeatinspam[i];
			for (j = 0; j < sizeN; j++) {
				if (Spam[i].equals(Nonspam[j])) {
					repeatinwhole[i] = repeatinspam[i] + repeatinnonspam[j];
				}
			}
		}
	}

	public static void main(String[] args) {
		int index = 0;
		int index2 = 0;
		int reps = 0;
		int i = 0;
		int same = 0;
		File file1 = new File("C:\\Users\\82109\\Desktop\\이산수학\\TrainingSpam.txt");
		File file2 = new File("C:\\Users\\82109\\Desktop\\이산수학\\TrainingNonSpam.txt");
		File file3 = new File("C:\\Users\\82109\\Desktop\\이산수학\\Testing.txt");
		try {
			FileReader filereader1 = new FileReader(file1);
			FileReader filereader2 = new FileReader(file2);
			FileReader filereader3 = new FileReader(file3);
			BufferedReader inFiles1 = new BufferedReader(filereader1);
			BufferedReader inFiles2 = new BufferedReader(filereader2);
			BufferedReader inFiles3 = new BufferedReader(filereader3);

			String line = "";
			System.out.println("Train Spam mails\n");
			while ((line = inFiles1.readLine()) != null) {
				StringTokenizer tk = new StringTokenizer(line);
				String token;
				token = tk.nextToken("_");
				spamword.add(token);
				token = tk.nextToken("@");
				token = token.replaceAll("_", "");
				spamword.add(token);
				token = tk.nextToken(".");
				token = token.replaceAll("@", "");
				spamword.add(token);
			}
			while ((line = inFiles2.readLine()) != null) {
				StringTokenizer tk = new StringTokenizer(line);
				String token;
				token = tk.nextToken("_");
				nonspamword.add(token);
				token = tk.nextToken("@");
				token = token.replaceAll("_", "");
				nonspamword.add(token);
				token = tk.nextToken(".");
				token = token.replaceAll("@", "");
				nonspamword.add(token);
			}
			filereader1.close();
			filereader2.close();
			inFiles1.close();
			inFiles2.close();

			for (String s : spamword) {
				spam[index] = s;
				index++;
			}

			for (String s : nonspamword) {
				for (i = 0; i < index; i++) {
					if (s.equals(spam[i])) {
						nonspam[index2] = s;
						index2++;
					}
				}
			}
			int repeats = 0;
			int count = 0;
			System.out.println("Words in Spam mails :\n");
			for (i = 0; i < index; i++) {
				FileReader filereader4 = new FileReader(file1);
				BufferedReader inFiles4 = new BufferedReader(filereader4);
				while ((line = inFiles4.readLine()) != null) {
					if (line.contains(spam[i])) {
						repeats++;
					}
				}
				repeatinspam[i] = repeats;
				System.out.println(spam[i] + " (repeats : " + repeatinspam[i] + ")");
				repeats = 0;
				filereader4.close();
				inFiles4.close();
			}
			repeats = 0;
			System.out.println("\nOverlapped Words with Spam mails in Normal mails :\n");
			for (i = 0; i < index2; i++) {
				FileReader filereader5 = new FileReader(file2);
				BufferedReader inFiles5 = new BufferedReader(filereader5);
				while ((line = inFiles5.readLine()) != null) {
					String s = nonspam[i];
					if (line.contains(s))
						repeats++;
				}
				repeatinnonspam[i] = repeats;
				repeats = 0;
				System.out.println(nonspam[i] + " (repeats : " + repeatinnonspam[i] + ")");
				filereader5.close();
				inFiles5.close();
			}
			repeatwhole(spam, nonspam, index, index2);
			int SpamCount = 0;
			System.out.println("\nResult of Test\n");
			while ((line = inFiles3.readLine()) != null) {
				if (bayesian_spam_filter(line, index)) {
					System.out.println(line + " is a Spam mail");
					SpamCount++;
				} else
					System.out.println(line + " is not a Spam mail");
			}
			filereader3.close();
			inFiles3.close();
			accuracy = (float) SpamCount / (float) 10;
			System.out.println("Accuracy : " + accuracy);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

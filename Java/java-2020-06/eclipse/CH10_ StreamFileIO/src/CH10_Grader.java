
import java.io.*;
import java.util.*; // StringTokenizer 포함

public class CH10_Grader {
	public static void main(String[] args) throws IOException {
		int[][] score = new int[8][4];
		int scorevalue;
		int i = 0, j = 0, k = 0;
		int[] sumstudent = new int[8];
		int[] sumclass = new int[4];
		float[] averagestudent = new float[8];
		float[] averageclass = new float[4];
		String average;

		for (i = 0; i < 8; i++) {
			if(i < 4) {
				sumclass[i] = 0;
			}
			sumstudent[i] = 0;
		}

		BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\82109\\Desktop\\자바\\grades.txt"));
		BufferedWriter w = new BufferedWriter(new FileWriter("C:\\Users\\82109\\Desktop\\자바\\StudentGrades_average.txt"));
		String line;
		i = -1;
		while ((line = b.readLine()) != null) // 라인의 값이 null 이 될때까지 읽어냄
		{
			/*
			 * ------------------------------------------------- 토큰라이저를 이용해 단어를 분리시킴
			 */
			StringTokenizer tk = new StringTokenizer(line, ",");
			String token;
			j = 0;
			k = 0;
			while (tk.hasMoreTokens()) {
				token = tk.nextToken();
				if (i >= 0) {
					if (j >= 2) {
						scorevalue = Integer.parseInt(token);
						score[i][k] = scorevalue;
						sumclass[k]+=scorevalue;
						sumstudent[i] += scorevalue;
						k++;
					}
				}
				if (i >= 0) {
					averagestudent[i] = (float) (sumstudent[i] / 4);
				}
				j++;
			}
			if(i == 7) {
				for(k = 0; k < 4; k++) {
					averageclass[k] = (float) (sumclass[k] / 8.00);
				}
			}
			w.write(line);
			if (i == -1) {
				w.write(", Average\n");
			} else if (i >= 0) {
				average = Float.toString(averagestudent[i]);
				w.write(',');
				w.write(average);
				w.write('\n');
			}
			i++;
		}
		w.write("Average,000000");
		for(i = 0; i < 4; i++) {
			average = Float.toString(averageclass[i]);
			w.write(',');
			w.write(average);
		}
		average = Float.toString((float)((averageclass[0]+averageclass[1]+averageclass[2]+averageclass[3]) / 4.0));
		w.write(',');
		w.write(average);
		
		w.close();
		b.close();
	}

}
import javax.swing.JOptionPane;
import java.util.*;
public class ReportCH0302 {
	public static void main(String[] args)	{
		String date;
		String mm;
		String dd;
		String yy;
		int TorF = 0;
		int num = 1;
		do	{
		do	{
		date = JOptionPane.showInputDialog("Enter a date");
		mm = date.substring(0,2);
		dd = date.substring(3,5);
		yy = date.substring(6,10);
		
		int m = Integer.parseInt(mm,10);
		int d = Integer.parseInt(dd,10);
		int y = Integer.parseInt(yy,10);			
		if(y >= 0 && d > 0 && m > 0) {
			if(m > 0 && m < 13) {
				if(m == 2) {
					if((y%4 == 0 && y%100 != 0) || y%400 == 0) { 
						if(d <= 29 && d > 0)	TorF = 1;
						}
					else if(y%4 != 0 || y%100 ==0){
						if(d <= 28 && d > 0)	TorF = 1;
						}
					}
				else if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
					if(d <= 31 && d > 0) TorF = 1;
					}
				else if(m == 4 || m == 6 || m == 9 || m == 11) {
					if(d <= 30 && d > 0)	TorF = 1;
					}
				}
			}
		if(TorF == 0)
			JOptionPane.showMessageDialog(null, "Wrong input!");
			}	while(TorF != 1 );
		if(TorF ==1) {
		num = JOptionPane.showConfirmDialog(null, mm + "/" + dd + "/" + yy + " is right date\nend program?", "Check Point", JOptionPane.YES_NO_OPTION);
		}
		} while(num != 0);
	}
}
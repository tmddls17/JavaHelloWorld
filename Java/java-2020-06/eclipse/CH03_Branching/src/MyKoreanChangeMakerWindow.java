import javax.swing.*;
public class MyKoreanChangeMakerWindow {
	public static void main(String[] args) {
	String input = JOptionPane.showInputDialog(
            "Enter a whole number from 1 to 10000");
	int won = Integer.parseInt(input);
	
	int won_500 = won/500;
	won = won%500;
	int won_100 = won/100;
	won = won%100;
	int won_10 = won/10;
	won =won%10;
	int won_5 = won/5;
	won = won%5;
	int won_1 = won;
	
	JOptionPane.showMessageDialog(null, won + "won in coins can be given as: \n" + won_500 + " 500 won\n" + won_100 + " 100 won\n" + won_10 + " 10 won\n" + won_5 + " 5 won\n" + won_1 + " 1 won");
	
	}
}
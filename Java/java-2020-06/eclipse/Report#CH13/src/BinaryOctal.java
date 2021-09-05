import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryOctal extends JFrame implements ActionListener {
	public static final int WIDTH = 650;
	public static final int HEIGHT = 300;
	// Container의 너비와 높이
	private JTextArea inputOutputField;// 사용자에게 값을 입력받는 JTextArea
	private JLabel label1;// 변환된 값의 결과를 보여주는 Label
	private JLabel label2;// 값의 변환 여부를 알리는 Label
	private String num;// JTextArea에 입력되는 값을 저장하는 변수

	public BinaryOctal() {
		setTitle("Enter a Credit Card number");
		addWindowListener(new WindowDestroyer());
		setSize(WIDTH, HEIGHT);
		// 코드를 실행 시, 화면에 뜨는 창의 높이와 너비, 제목을 설정
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 2));
		JPanel textPanel = new JPanel();
		inputOutputField = new JTextArea(2, 30);
		// 창을 Container로 설정하고 레이아웃을 GridLayout으로 설정한다.
		textPanel.add(inputOutputField);
		contentPane.add(textPanel, BorderLayout.NORTH);
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new FlowLayout());
		JButton addButton1 = new JButton("Convert to Binary");
		addButton1.addActionListener(this);
		buttonPanel1.add(addButton1);
		contentPane.add(buttonPanel1, BorderLayout.NORTH);
		label1 = new JLabel();
		contentPane.add(label1, BorderLayout.CENTER);
		JPanel buttonPanel2 = new JPanel();
		JButton addButton2 = new JButton("Convert to Octal");
		addButton2.addActionListener(this);
		buttonPanel2.add(addButton2);
		contentPane.add(buttonPanel2, BorderLayout.CENTER);
		label2 = new JLabel();
		contentPane.add(label2, BorderLayout.SOUTH);
		JPanel buttonPanel3 = new JPanel();
		JButton addButton3 = new JButton("          Clear         ");
		addButton3.addActionListener(this);
		buttonPanel3.add(addButton3);
		contentPane.add(buttonPanel3, BorderLayout.SOUTH);
		//화면에 표시할 입력창과 버튼 그리고 Label의 위치를 알맞게 선언해준다.
	}

	public void actionPerformed(ActionEvent e) {
		tryingConvertBinary(e);
		tryingConvertOctal(e);
		tryingClear(e);
		// 버튼이 눌러져 ActionEvent가 발생했을 때, 다른 메서드들을 호출한다.
	}

	public void tryingConvertBinary(ActionEvent e) {
		int TorF = 1;
		// 오류인지 아닌지 확인하는 변수
		int Octal;
		// num의 숫자를 한 자리 단위로 기억하는 변수
		int i = 0;
		// 반복문 변수
		int max;
		// num의 길이, 반복문을 시행할 횟수
		String Binary = "";
		// 변환한 값을 저장하는 변수
		if (e.getActionCommand().equals("Convert to Binary")) {
			num = inputOutputField.getText();
			// inputOutputField에 입력된 값을 num에 저장
			max = num.length();
			//num의 길이를 max에 저장
			for (i = 0; i < max; i++) {
				Octal = Integer.parseInt(num.substring(i, i + 1));
				//한 자리 단위로 num을 나누어 Octal에 잠시 저장
				if (Octal == 0) {
					Binary = Binary.concat("000");
					TorF = 0;
				} else if (Octal == 1) {
					Binary = Binary.concat("001");
					TorF = 0;
				} else if (Octal == 2) {
					Binary = Binary.concat("010");
					TorF = 0;
				} else if (Octal == 3) {
					Binary = Binary.concat("011");
					TorF = 0;
				} else if (Octal == 4) {
					Binary = Binary.concat("100");
					TorF = 0;
				} else if (Octal == 5) {
					Binary = Binary.concat("101");
					TorF = 0;
				} else if (Octal == 6) {
					Binary = Binary.concat("110");
					TorF = 0;
				} else if (Octal == 7) {
					Binary = Binary.concat("111");
					TorF = 0; 
					//Octal이 0 ~ 7의 값을 가질 때 위와 같이 실행
				} else if (Octal >= 8) {
					TorF = 1;
					break;
				}// Octal이 8이상의 값을 가질 때 위와 같이 실행
			}
			if (TorF == 0) {
				label1.setText(Binary);
				label2.setText("Value converted to binary.");
			} else if (TorF == 1)
				label2.setText("Sorry, can not converted that.");
		}// TorF의 값에 따라 실행되는 코드가 달라짐
	}

	public void tryingConvertOctal(ActionEvent e) {
		int TorF = 1;
		// 오류인지 아닌지 확인하는 변수
		int i = 0;
		// 반복문 변수
		int max;
		// num의 길이를 저장하는 변수
		String Binary = "";
		// num의 값을 3개 단위로 묶어서 임시 기억하는 변수
		String Oct = "";
		// 변환된 값을 저장하는 변수
		String Zero = "0";
		// num의 자릿수가 3으로 나뉘지 않을 경우 더해야 하는 0
		if (e.getActionCommand().equals("Convert to Octal")) {
			num = inputOutputField.getText();
			if (num.length() % 3 == 0) {
				max = num.length();
			} else {
				do {
					num = Zero.concat(num);
				} while (num.length() % 3 != 0);
				max = num.length();
			}
			// num의 자릿수가 3으로 나뉘지 않을 경우 3으로 나뉠 때까지 0을 앞에 더해준다.
			for (i = 0; i < max; i += 3) {
				Binary = num.substring(i, i + 3);
				if (Binary.equals("000")) {
					Oct = Oct.concat("0");
					TorF = 0;
				} else if (Binary.equals("001")) {
					Oct = Oct.concat("1");
					TorF = 0;
				} else if (Binary.equals("010")) {
					Oct = Oct.concat("2");
					TorF = 0;
				} else if (Binary.equals("011")) {
					Oct = Oct.concat("3");
					TorF = 0;
				} else if (Binary.equals("100")) {
					Oct = Oct.concat("4");
					TorF = 0;
				} else if (Binary.equals("101")) {
					Oct = Oct.concat("5");
					TorF = 0;
				} else if (Binary.equals("110")) {
					Oct = Oct.concat("6");
					TorF = 0;
				} else if (Binary.equals("111")) {
					Oct = Oct.concat("7");
					TorF = 0;
					//Binary가 000 ~ 111까지 해당될 때 위와 같이 실행
				} else {
					TorF = 1;
					break;
					// 0, 1이외의 값이 인식될 경우 위와 같이 실행
				}
			}
			if (TorF == 0) {
				label1.setText(Oct);
				label2.setText("Value converted to octal.");
			} else if (TorF == 1)
				label2.setText("Sorry, can not converted that.");
		}//TorF의 값에 따라 해당되는 코드를 실행
	}

	public void tryingClear(ActionEvent e) {
		if (e.getActionCommand().equals("          Clear         ")) {
			inputOutputField.setText("");
			label1.setText("");
			label2.setText("");
		}//Clear버튼을 눌렀을 경우 모든 Label과 JTextArea를 초기화한다.
	}

	public static void main(String[] args) {
		BinaryOctal window1 = new BinaryOctal();
		window1.setVisible(true);
	}// 클래스에 입력된 창을 화면에 띄운다.
}
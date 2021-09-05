import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryOctal extends JFrame implements ActionListener {
	public static final int WIDTH = 650;
	public static final int HEIGHT = 300;
	// Container�� �ʺ�� ����
	private JTextArea inputOutputField;// ����ڿ��� ���� �Է¹޴� JTextArea
	private JLabel label1;// ��ȯ�� ���� ����� �����ִ� Label
	private JLabel label2;// ���� ��ȯ ���θ� �˸��� Label
	private String num;// JTextArea�� �ԷµǴ� ���� �����ϴ� ����

	public BinaryOctal() {
		setTitle("Enter a Credit Card number");
		addWindowListener(new WindowDestroyer());
		setSize(WIDTH, HEIGHT);
		// �ڵ带 ���� ��, ȭ�鿡 �ߴ� â�� ���̿� �ʺ�, ������ ����
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 2));
		JPanel textPanel = new JPanel();
		inputOutputField = new JTextArea(2, 30);
		// â�� Container�� �����ϰ� ���̾ƿ��� GridLayout���� �����Ѵ�.
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
		//ȭ�鿡 ǥ���� �Է�â�� ��ư �׸��� Label�� ��ġ�� �˸°� �������ش�.
	}

	public void actionPerformed(ActionEvent e) {
		tryingConvertBinary(e);
		tryingConvertOctal(e);
		tryingClear(e);
		// ��ư�� ������ ActionEvent�� �߻����� ��, �ٸ� �޼������ ȣ���Ѵ�.
	}

	public void tryingConvertBinary(ActionEvent e) {
		int TorF = 1;
		// �������� �ƴ��� Ȯ���ϴ� ����
		int Octal;
		// num�� ���ڸ� �� �ڸ� ������ ����ϴ� ����
		int i = 0;
		// �ݺ��� ����
		int max;
		// num�� ����, �ݺ����� ������ Ƚ��
		String Binary = "";
		// ��ȯ�� ���� �����ϴ� ����
		if (e.getActionCommand().equals("Convert to Binary")) {
			num = inputOutputField.getText();
			// inputOutputField�� �Էµ� ���� num�� ����
			max = num.length();
			//num�� ���̸� max�� ����
			for (i = 0; i < max; i++) {
				Octal = Integer.parseInt(num.substring(i, i + 1));
				//�� �ڸ� ������ num�� ������ Octal�� ��� ����
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
					//Octal�� 0 ~ 7�� ���� ���� �� ���� ���� ����
				} else if (Octal >= 8) {
					TorF = 1;
					break;
				}// Octal�� 8�̻��� ���� ���� �� ���� ���� ����
			}
			if (TorF == 0) {
				label1.setText(Binary);
				label2.setText("Value converted to binary.");
			} else if (TorF == 1)
				label2.setText("Sorry, can not converted that.");
		}// TorF�� ���� ���� ����Ǵ� �ڵ尡 �޶���
	}

	public void tryingConvertOctal(ActionEvent e) {
		int TorF = 1;
		// �������� �ƴ��� Ȯ���ϴ� ����
		int i = 0;
		// �ݺ��� ����
		int max;
		// num�� ���̸� �����ϴ� ����
		String Binary = "";
		// num�� ���� 3�� ������ ��� �ӽ� ����ϴ� ����
		String Oct = "";
		// ��ȯ�� ���� �����ϴ� ����
		String Zero = "0";
		// num�� �ڸ����� 3���� ������ ���� ��� ���ؾ� �ϴ� 0
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
			// num�� �ڸ����� 3���� ������ ���� ��� 3���� ���� ������ 0�� �տ� �����ش�.
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
					//Binary�� 000 ~ 111���� �ش�� �� ���� ���� ����
				} else {
					TorF = 1;
					break;
					// 0, 1�̿��� ���� �νĵ� ��� ���� ���� ����
				}
			}
			if (TorF == 0) {
				label1.setText(Oct);
				label2.setText("Value converted to octal.");
			} else if (TorF == 1)
				label2.setText("Sorry, can not converted that.");
		}//TorF�� ���� ���� �ش�Ǵ� �ڵ带 ����
	}

	public void tryingClear(ActionEvent e) {
		if (e.getActionCommand().equals("          Clear         ")) {
			inputOutputField.setText("");
			label1.setText("");
			label2.setText("");
		}//Clear��ư�� ������ ��� ��� Label�� JTextArea�� �ʱ�ȭ�Ѵ�.
	}

	public static void main(String[] args) {
		BinaryOctal window1 = new BinaryOctal();
		window1.setVisible(true);
	}// Ŭ������ �Էµ� â�� ȭ�鿡 ����.
}
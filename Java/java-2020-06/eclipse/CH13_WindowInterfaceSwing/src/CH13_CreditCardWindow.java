import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CH13_CreditCardWindow extends JFrame implements ActionListener {
	public static final int WIDTH = 400;
	public static final int HEIGHT = 90;
	private JTextField inputOutputField;
	private JLabel label1;
	private String num;

	public CH13_CreditCardWindow() {
		addWindowListener(new WindowDestroyer());
		setSize(WIDTH, HEIGHT);
		setTitle("Enter a Credit Card number");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton addButton = new JButton("Accept");
		addButton.addActionListener(this);
		buttonPanel.add(addButton);
		contentPane.add(buttonPanel, BorderLayout.EAST);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		inputOutputField = new JTextField("", 30);
		textPanel.add(inputOutputField);
		contentPane.add(textPanel, BorderLayout.CENTER);
		label1 = new JLabel();
		contentPane.add(label1, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			tryingCorrectNumberFormats(e);
		} catch (NumberFormatException e2) {
			inputOutputField.setText("Error: Reenter Number.");
		}
	}

	public void tryingCorrectNumberFormats(ActionEvent e) {
		int TorF = 0;
		if (e.getActionCommand().equals("Accept")) {
			num = inputOutputField.getText();
			if (num.length() == 16) {
				for (int i = 0; i < num.length(); i++) {
					int a = Integer.parseInt(num.substring(i, i + 1));
					if (0 <= a && a <= 9) {
						TorF = 1;
					} else
						TorF = 0;
				}
				if (TorF == 1) {
					inputOutputField.setText("");
					label1.setText("Number accepted " + num);
				}
			} else
				label1.setText("Number rejected " + num);
		}
	}

	public static void main(String[] args) {
		CH13_CreditCardWindow window1 = new CH13_CreditCardWindow();
		window1.setVisible(true);
	}
}
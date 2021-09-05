import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CH15_SundaeCreator extends JFrame implements ActionListener {
	public static final int WIDTH = 350;
	public static final int HEIGHT = 250;
	public static final int LINES = 10;
	public static final int CHAR_PER_LINE = 40;
	private JTextArea theText;
	private String memo1 = "No Memo 1.";
	private String memo2 = "No Memo 2.";
	private JLabel label1;

	public CH15_SundaeCreator() {
		setSize(WIDTH, HEIGHT);
		addWindowListener(new WindowDestroyer());
		setTitle("Borders Sampler");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JMenu Bordermenu = new JMenu("Borders");
		JMenuItem m;
		JMenu Beveled = new JMenu("Beveled Borders");
		m = new JMenuItem("Raised");
		m.addActionListener(this);
		Beveled.add(m);
		m = new JMenuItem("Lowered");
		m.addActionListener(this);
		Beveled.add(m);
		Bordermenu.add(Beveled);
		JMenu Etched = new JMenu("Etched Borders");
		m = new JMenuItem("Raised");
		m.addActionListener(this);
		Etched.add(m);
		m = new JMenuItem("Lowered");
		m.addActionListener(this);
		Etched.add(m);
		Bordermenu.add(Etched);
		JMenu Line = new JMenu("Line Borders");
		m.addActionListener(this);
		JMenu Small = new JMenu("Small");
		m.addActionListener(this);
		Line.add(m);
		JMenu Medium = new JMenu("Medium");
		m.addActionListener(this);
		Line.add(m);
		JMenu Large = new JMenu("Large");
		m.addActionListener(this);
		Line.add(m);
		Bordermenu.add(Line);
		m = new JMenuItem("Exit");
		m.addActionListener(this);
		Bordermenu.add(m);
		JMenuBar mBar = new JMenuBar();
		mBar.add(Bordermenu);
		setJMenuBar(mBar);
		JPanel textPanel = new JPanel();
		label1 = new JLabel();
		contentPane.add(label1, BorderLayout.CENTER);
		label1.setText("Select a border from menu");
		
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Save Memo 1"))
			memo1 = theText.getText();
		else if (actionCommand.equals("Save Memo 2"))
			memo2 = theText.getText();
		else if (actionCommand.equals("Clear"))
			theText.setText("");
		else if (actionCommand.equals("Get Memo 1"))
			theText.setText(memo1);
		else if (actionCommand.equals("Get Memo 2"))
			theText.setText(memo2);
		else if (actionCommand.equals("Exit"))
			System.exit(0);
		else
			theText.setText("Error in memo interface");
	}

	public static void main(String[] args) {
		CH15_SundaeCreator gui = new CH15_SundaeCreator();
		gui.setVisible(true);
	}
}
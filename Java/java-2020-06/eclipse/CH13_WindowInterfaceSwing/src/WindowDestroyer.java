import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowDestroyer implements WindowListener {

	@Override
	public void windowActivated(WindowEvent arg0) {
		System.out.println("Window Activated");

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.out.println("Window Closed");

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		System.out.println("Window Deactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		System.out.println("WindowDeiconified");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
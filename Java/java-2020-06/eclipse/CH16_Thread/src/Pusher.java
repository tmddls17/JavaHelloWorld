
public class Pusher extends Thread {
	protected BoundedStack stack;
	protected int n;

	public Pusher(BoundedStack stack, int n) {
		this.stack = stack;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			stack.put(new Integer(i));
			System.out.println("push: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}

public class Poper extends Thread {
	protected BoundedStack stack;
	protected int n;

	public Poper(BoundedStack stack, int n) {
		this.stack = stack;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			Object obj = stack.get();
			if (obj != null)
				System.out.println("\tpop: " + obj);
			try {
				sleep((int) (Math.random() * 400));
			} catch (InterruptedException e) {
			}
		}
	}
}
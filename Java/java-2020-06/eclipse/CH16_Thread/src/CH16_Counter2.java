public class CH16_Counter2 implements Runnable {
	protected int count;
	protected int inc;
	protected int delay;

	public CH16_Counter2(int init, int inc, int delay) {
		this.count = init;
		this.inc = inc;
		this.delay = delay;
	}

	public void run() {
		try {
			for (;count > -10;) {
				System.out.print(count + " count2\n");
				count += inc;
				Thread.sleep(delay);
			}
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		new Thread(new CH16_Counter2(0, 1, 33)).start();
		new Thread(new CH16_Counter2(0, -1, 100)).start();
	}
}

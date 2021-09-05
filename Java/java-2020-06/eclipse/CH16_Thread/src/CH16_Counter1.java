public class CH16_Counter1 extends Thread {
	protected int count;
	protected int inc;
	protected int delay;

	public CH16_Counter1(int init, int inc, int delay) {
		this.count = init;
		this.inc = inc;
		this.delay = delay;
	}

	public void run() {
		try {
			for (;count < 10;) {
				System.out.print(count + " count1\n");
				count += inc;
				sleep(delay);
			}
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		new CH16_Counter1(0, 1, 33).start();
		new CH16_Counter1(0, -1, 100).start();
	}
}
 // 1ÃÊ


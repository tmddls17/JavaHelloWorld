
public class CH16_ThreadMain {
	public static void main(String[] args) {
		new CH16_Counter1(0, 1, 1000).start(); // 1ÃÊ
		new Thread(new CH16_Counter2(0, -1, 2000)).start();
	}
}
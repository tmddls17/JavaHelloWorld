
public class CH16_ThreadStackMain {
	public static void main(String[] args) {
		BoundedStackWithGuard stack = new BoundedStackWithGuard(3);
		new Pusher(stack, 15).start();
		new Poper(stack, 15).start();
	}
}
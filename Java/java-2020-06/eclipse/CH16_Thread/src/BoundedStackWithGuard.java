
public class BoundedStackWithGuard extends BoundedStack {
	public BoundedStackWithGuard(int size) {
		super(size);
	}

	synchronized public boolean isEmpty() {
		return super.isEmpty();
	}

	synchronized public boolean isFull() {
		return super.isFull();
	}

	synchronized public int getCount() {
		return super.getCount();
	}

	synchronized public void put(Object obj) {
		try {
			while (isFull()) {
				wait();
			}
		} catch (InterruptedException e) {
		}
		super.put(obj);
		notify();
	}

	synchronized public Object get() {
		try {
			while (isEmpty()) {
				wait();
			}
		} catch (InterruptedException e) {
		}
		Object result = super.get();
		notify();
		return result;
	}

	public static void main(String args[]) {
		BoundedStackWithGuard stack = new BoundedStackWithGuard(3);
		new Pusher(stack, 15).start();
		new Poper(stack, 15).start();
	}
}
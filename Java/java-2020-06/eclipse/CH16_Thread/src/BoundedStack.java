
public class BoundedStack {
	protected Object rep[];
	protected int front = 0;
	protected int back = -1;
	protected int size = 0;
	protected int count = 0;

	public BoundedStack(int size) {
		if (size > 0) {
			this.size = size;
			rep = new Object[size];
			back = size - 1;
		}
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return (count == size);
	}

	public int getCount() {
		return count;
	}

	public void put(Object e) {
		if (e != null && !isFull()) {
			back++;
			if (back >= size)
				back = 0;
			rep[back] = e;
			count++;
		}
	}

	public Object get() {
		Object result = null;
		if (!isEmpty()) {
			result = rep[back];
			rep[back] = null;
			back--;
			if (back >= size)
				back = 0;
			count--;
		}
		return result;
	}

	public static void main(String args[]) {
		BoundedStack stack = new BoundedStack(10);
		for (int i = 0; !stack.isFull(); i++) {
			stack.put(new Integer(i));
			System.out.println("put: " + i);
		}
		while (!stack.isEmpty()) {
			System.out.println("get: " + stack.get());
		}
	}
}
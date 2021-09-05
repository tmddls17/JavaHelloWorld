public class LinkedQueue<T> {
	private Object[] front = new Object[10];
	private int count = 0;
	// ���׸� Ŭ���� ���� �ԷµǴ� ���� ������ Object�迭 front�� �迭�� ����� ���� ������ �����ϴ� count

	private void addToQueue(T value) {
		front[count++] = value;
	}
	// ���׸��� ���� ��ƼŸ���� �Ķ���ͷ� �޾Ƽ� Object�迭�� �����ϰ� count ���� ������Ű�� �޼���
	
	private int length() {
		int length = 0;
		length = count;
		return length;
	}
	// Object�迭�� ũ�⸦ ��ȯ�ϴ� �޼���

	private void showQueue() {
		int i = 0;
		for(i = 0; i < count; i++) {
			System.out.println(front[i]);
		}
	}
	//Object�迭�� ����� ���� ����ϴ� �޼���
	
	private String removeFromQueue() {
		String removed = null;
		int i = 0;
		for(i = 0; i < count; i++) {
			if(i == 0) {
				removed = (String) front[i];
			}
			else {
				front[i - 1] = front[i];
			}
		}
		if(count > 0)
			count--;
		return removed;
	}
	// Object �迭�� ����� ���� ���� ���� return�ϸ� �����ϰ� count�� ���� 1 ���̴� �޼���
	// ����� ���� ���ٸ� null���� return�ϸ� count�� ���� ������ ����.
	
	private boolean isEmpty() {
		if(count == 0)
			return true;
		return false;
	}
	// count�� ���� 0���� �ƴ��� Ȯ���Ͽ� Object �迭�� ���� �����ϴ����� ���θ� ������ �޼���
	
	public static void main(String[] args) {
		LinkedQueue<String> q = new LinkedQueue<String>();
		// ���׸� Ŭ���� q���� �ٷ� Object�� ���������� String���� ���� 
		
		q.addToQueue("One");
		q.addToQueue("Two");
		q.addToQueue("Three");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// One, Two, Three�� ����ְ� queue�� ���̿� ����ִ� ���� ���

		String data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// ���� ó���� ��ġ�� ���� ���� �Ŀ� ���̿� ����ִ� ���� ��� ("One" ����, ����: 2)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// �迭�� ������� Ȯ��(False)
		
		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// ���� ó���� ��ġ�� ���� ���� �Ŀ� ���̿� ����ִ� ���� ��� ("Two" ����, ����: 1)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// �迭�� ������� Ȯ�� (False)

		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// ���� ó���� ��ġ�� ���� ���� �Ŀ� ���̿� ����ִ� ���� ��� ("Three" ����, ����: 0)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// �迭�� ������� Ȯ�� (True)
		
		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// ���� ó���� ��ġ�� ���� ���� �Ŀ� ���̿� ����ִ� ���� ��� (������ �� ���� "null"���, ����: 0)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// �迭�� ������� Ȯ�� (True)
		
		q.addToQueue("Four");
		System.out.println("\nAdded Four to end of queue ");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// "Four"�� �迭�� �߰� (���� 1)
		
		q.addToQueue("Five");
		System.out.println("\nAdded Five to end of queue ");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		//"Five"�� �迭�� �߰� (���� 2)

		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// ���� ó���� ��ġ�� ���� ���� �Ŀ� ���̿� ����ִ� ���� ��� ("Four" ����, ����: 1)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// �迭�� ������� Ȯ�� (False)
	}
}

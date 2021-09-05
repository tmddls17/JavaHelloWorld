public class LinkedQueue<T> {
	private Object[] front = new Object[10];
	private int count = 0;
	// 제네릭 클래스 내의 입력되는 값을 저장할 Object배열 front와 배열에 저장된 값의 갯수를 저장하는 count

	private void addToQueue(T value) {
		front[count++] = value;
	}
	// 제네릭을 통해 멀티타입을 파라미터로 받아서 Object배열에 저장하고 count 값을 증가시키는 메서드
	
	private int length() {
		int length = 0;
		length = count;
		return length;
	}
	// Object배열의 크기를 반환하는 메서드

	private void showQueue() {
		int i = 0;
		for(i = 0; i < count; i++) {
			System.out.println(front[i]);
		}
	}
	//Object배열에 저장된 값을 출력하는 메서드
	
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
	// Object 배열에 저장된 가장 앞의 값을 return하며 제거하고 count의 값을 1 줄이는 메서드
	// 저장된 값이 없다면 null값을 return하며 count의 값은 변동이 없다.
	
	private boolean isEmpty() {
		if(count == 0)
			return true;
		return false;
	}
	// count의 값이 0인지 아닌지 확인하여 Object 배열에 값이 존재하는지의 여부를 따지는 메서드
	
	public static void main(String[] args) {
		LinkedQueue<String> q = new LinkedQueue<String>();
		// 제네릭 클래스 q에서 다룰 Object의 데이터형을 String으로 선언 
		
		q.addToQueue("One");
		q.addToQueue("Two");
		q.addToQueue("Three");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// One, Two, Three를 집어넣고 queue의 길이와 들어있는 값을 출력

		String data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// 가장 처음에 위치한 값을 제거 후에 길이와 들어있는 값을 출력 ("One" 제거, 길이: 2)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// 배열이 비었는지 확인(False)
		
		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// 가장 처음에 위치한 값을 제거 후에 길이와 들어있는 값을 출력 ("Two" 제거, 길이: 1)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// 배열이 비었는지 확인 (False)

		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// 가장 처음에 위치한 값을 제거 후에 길이와 들어있는 값을 출력 ("Three" 제거, 길이: 0)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// 배열이 비었는지 확인 (True)
		
		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// 가장 처음에 위치한 값을 제거 후에 길이와 들어있는 값을 출력 (제거할 값 없음 "null"출력, 길이: 0)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// 배열이 비었는지 확인 (True)
		
		q.addToQueue("Four");
		System.out.println("\nAdded Four to end of queue ");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// "Four"를 배열에 추가 (길이 1)
		
		q.addToQueue("Five");
		System.out.println("\nAdded Five to end of queue ");
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		//"Five"를 배열에 추가 (길이 2)

		data = q.removeFromQueue();
		System.out.println("\nRemoved the front item from the queue " + data);
		System.out.println("Queue has " + q.length() + " entries.");
		System.out.println("Start of queue:");
		q.showQueue();
		System.out.println("End of queue.");
		// 가장 처음에 위치한 값을 제거 후에 길이와 들어있는 값을 출력 ("Four" 제거, 길이: 1)
		System.out.println("Is the queue empty? " + q.isEmpty());
		// 배열이 비었는지 확인 (False)
	}
}

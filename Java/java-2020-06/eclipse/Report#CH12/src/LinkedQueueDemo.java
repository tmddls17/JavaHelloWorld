/*
 * LinkedQueueDemo.java
 *
 * Solution to Project 11
 */


public class LinkedQueueDemo {
    public static void main(String[] args) {
        LinkedQueue<String> q = new LinkedQueue<String>();
        q.addToQueue("One");
        q.addToQueue("Two");
        q.addToQueue("Three");
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");

        String data = q.removeFromQueue();
        System.out.println("\nRemoved the front item from the queue " + data);
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");

        System.out.println("Is the queue empty? " + q.isEmpty());

        data = q.removeFromQueue();
        System.out.println("\nRemoved the front item from the queue " + data);
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");
        System.out.println("Is the queue empty? " + q.isEmpty());


        data = q.removeFromQueue();
        System.out.println("\nRemoved the front item from the queue " + data);
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");
        System.out.println("Is the queue empty? " + q.isEmpty());



        data = q.removeFromQueue();
        System.out.println("\nRemoved the front item from the queue " + data);
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");
        System.out.println("Is the queue empty? " + q.isEmpty());

        q.addToQueue("Four");
        System.out.println("\nAdded Four to end of queue ");
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");

        q.addToQueue("Five");
        System.out.println("\nAdded Five to end of queue ");
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");

        data = q.removeFromQueue();
        System.out.println("\nRemoved the front item from the queue " + data);
        System.out.println("Queue has " + q.length() +
                " entries.");
        System.out.println("Start of queue:");
        q.showQueue();
        System.out.println("End of queue.");
        System.out.println("Is the queue empty? " + q.isEmpty());

    }
}


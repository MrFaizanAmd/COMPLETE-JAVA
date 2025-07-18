import java.util.concurrent.*;

public class LinkedTransferQueueExample {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<>();

        // Consumer Thread: Takes messages from the queue
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate processing delay
                System.out.println("Consumer received: " + queue.take()); // Blocks until an element is available
                System.out.println("Consumer received: " + queue.take());
                System.out.println("Consumer received: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Producer Thread: Transfers messages
        new Thread(() -> {
            try {
                System.out.println("Producer: Waiting for consumer...");
                queue.transfer("Message 1"); // Blocks until consumed
                System.out.println("Producer: Message 1 delivered!");

                queue.put("Message 2"); // Adds without waiting
                System.out.println("Producer: Message 2 added to queue!");

                if (queue.tryTransfer("Message 3")) {
                    System.out.println("Producer: Message 3 transferred immediately!");
                } else {
                    System.out.println("Producer: Message 3 added but not yet received.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

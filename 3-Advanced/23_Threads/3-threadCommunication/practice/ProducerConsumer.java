class DataBuffer {
    private final int[] buffer;
    private int count = 0;
    private final int capacity = 5;
    private int in = 0;
    private int out = 0;

    public DataBuffer() {
        buffer = new int[capacity];
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (count == capacity) {
            System.out.println("Buffer full! Producer is waiting...");
            wait();
        }
        buffer[in] = value;
        in = (in + 1) % capacity; // Move to the next slot in the buffer
        count++;
        System.out.println("Produced: " + value);
        notify(); // Notify consumer
    }

    public synchronized void consume() throws InterruptedException {
        while (count == 0) {
            System.out.println("Buffer empty! Consumer is waiting...");
            wait();
        }
        int value = buffer[out];
        out = (out + 1) % capacity; // Move to the next slot in the buffer
        count--;
        System.out.println("Consumed: " + value);
        notify(); // Notify producer
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        DataBuffer buffer = new DataBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        
        consumer.start();
    }
}

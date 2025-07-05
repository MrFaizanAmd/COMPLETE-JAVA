class SharedData {
    private int data = 0;

    public synchronized void increment() {
        data++;
        System.out.println(Thread.currentThread().getName() + " incremented value: " + data);
    }
}

class DataModifier extends Thread {
    private SharedData sharedData;

    public DataModifier(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedData.increment();
        }
    }
}

public class EditExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread t1 = new DataModifier(sharedData);
        Thread t2 = new DataModifier(sharedData);

        t1.start();
        t2.start();
    }
}

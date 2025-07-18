// 3. Print Numbers Using Multiple Threads (Synchronized Method)
class Printer {
    public synchronized void printNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(Thread.currentThread().getName() + " prints: " + i);
        }
    }
}
class NumberThread extends Thread {
    private Printer printer;
    private int n;
    
    public NumberThread(Printer printer, int n) {
        this.printer = printer;
        this.n = n;
    }
    
    public void run() {
        printer.printNumbers(n);
    }
}
public class PrintExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new NumberThread(printer, 5);
        Thread t2 = new NumberThread(printer, 5);
        
        t1.start();
        t2.start();
    }
}

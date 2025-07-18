import java.util.concurrent.locks.ReentrantReadWriteLock;

class StockMarket {
    private double price = 100.0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void getPrice(String trader) {
        lock.readLock().lock();
        try {
            System.out.println(trader + " checked stock price: $" + price);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updatePrice(double newPrice) {
        lock.writeLock().lock();
        try {
            System.out.println("Updating stock price to: $" + newPrice);
            Thread.sleep(1000);
            price = newPrice;
            System.out.println("Stock price updated.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class Trader extends Thread {
    private StockMarket market;
    private String name;

    public Trader(StockMarket market, String name) {
        this.market = market;
        this.name = name;
    }

    public void run() {
        market.getPrice(name);
    }
}

class StockUpdater extends Thread {
    private StockMarket market;
    private double newPrice;

    public StockUpdater(StockMarket market, double newPrice) {
        this.market = market;
        this.newPrice = newPrice;
    }

    public void run() {
        market.updatePrice(newPrice);
    }
}

public class StockExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Thread t1 = new Trader(market, "Trader A");
        Thread t2 = new Trader(market, "Trader B");
        Thread updater = new StockUpdater(market, 120.5);

        t1.start();
        t2.start();
        updater.start();
    }
}

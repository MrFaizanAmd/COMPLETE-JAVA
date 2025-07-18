import java.util.concurrent.locks.ReentrantReadWriteLock;

class Configuration {
    private String settings = "Default Config";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readConfig(String service) {
        lock.readLock().lock();
        try {
            System.out.println(service + " read settings: " + settings);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updateConfig(String newConfig) {
        lock.writeLock().lock();
        try {
            System.out.println("Updating settings to: " + newConfig);
            Thread.sleep(1000);
            settings = newConfig;
            System.out.println("Settings updated.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class Service extends Thread {
    private Configuration config;
    private String name;

    public Service(Configuration config, String name) {
        this.config = config;
        this.name = name;
    }

    public void run() {
        config.readConfig(name);
    }
}

class Admin extends Thread {
    private Configuration config;
    private String newConfig;

    public Admin(Configuration config, String newConfig) {
        this.config = config;
        this.newConfig = newConfig;
    }

    public void run() {
        config.updateConfig(newConfig);
    }
}

public class ConfigExample {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        Thread service1 = new Service(config, "Service X");
        Thread service2 = new Service(config, "Service Y");
        Thread admin = new Admin(config, "Updated Config");

        service1.start();
        service2.start();
        admin.start();
    }
}

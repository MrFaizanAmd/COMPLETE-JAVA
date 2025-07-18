class SharedResource {
    public synchronized void accessResource(String name) {
        System.out.println(name + " is accessing the resource.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " has finished accessing the resource.");
    }
}
class ResourceUser extends Thread {
    private SharedResource resource;
    private String name;
    
    public ResourceUser(SharedResource resource, String name) {
        this.resource = resource;
        this.name = name;
    }
    
    public void run() {
        resource.accessResource(name);
    }
}
public class ResourceExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread t1 = new ResourceUser(resource, "Thread 1");
        Thread t2 = new ResourceUser(resource, "Thread 2");
        
        t1.start();
        t2.start();
    }
}

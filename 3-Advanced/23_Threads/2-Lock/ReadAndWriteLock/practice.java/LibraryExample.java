import java.util.concurrent.locks.ReentrantReadWriteLock;

class Library {
    private String book = "Java Multithreading";
    private final ReentrantReadWriteLock lock;

    Library() {
        this.lock = new ReentrantReadWriteLock();
    }

    public void readBook(String reader) {
        lock.readLock().lock();
        try {
            System.out.println(reader + " is reading the book: " + book);
            Thread.sleep(1000);
            System.out.println(reader + " finished reading.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void updateBook(String newBook) {
        lock.writeLock().lock();
        try {
            System.out.println("Updating book to: " + newBook);
            Thread.sleep(1000);
            book = newBook;
            System.out.println("Book updated.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class Reader extends Thread {
    private  Library library;
    private String name;

    public Reader(Library library, String name) {
        this.library = library;
        this.name = name;
    }

    public void run() {
        library.readBook(name);
    }
}

class Writer extends Thread {
    private Library library;
    private String newBook;

    public Writer(Library library, String newBook) {
        this.library = library;
        this.newBook = newBook;
    }

    public void run() {
        library.updateBook(newBook);
    }
}

public class LibraryExample {
    public static void main(String[] args) {
        Library library = new Library();
        Thread r1 = new Reader(library, "Alice");
        Thread r2 = new Reader(library, "Bob");
        Thread w1 = new Writer(library, "Advanced Java");

        r1.start();
        r2.start();
        
        w1.start();
    }
}

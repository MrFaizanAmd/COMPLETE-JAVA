import java.util.concurrent.locks.ReentrantLock;

class TicketBooking {
    private int availableTickets = 5;
    private final ReentrantLock lock = new ReentrantLock();

    public void bookTicket(String name, int tickets) {
        if (lock.tryLock()) {  // Try acquiring lock without waiting
            try {
                if (availableTickets >= tickets) {
                    System.out.println(name + " booked " + tickets + " ticket(s)");
                    availableTickets -= tickets;
                } else {
                    System.out.println("Not enough tickets for " + name);
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " couldn't book tickets as another process is running.");
        }
    }
}

class Passenger extends Thread {
    private TicketBooking booking;
    private String name;
    private int tickets;

    public Passenger(TicketBooking booking, String name, int tickets) {
        this.booking = booking;
        this.name = name;
        this.tickets = tickets;
    }

    public void run() {
        booking.bookTicket(name, tickets);
    }
}

public class TicketExample {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        Thread t1 = new Passenger(booking, "Alice", 2);
        Thread t2 = new Passenger(booking, "Bob", 4);

        t1.start();
        t2.start();
    }
}

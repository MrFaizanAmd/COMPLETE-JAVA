import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ChatHistory {
    private final List<String> messages = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Read messages (Multiple users can read at the same time)
    public void readMessages(String user) {
        lock.readLock().lock();
        try {
            System.out.println(user + " is reading chat history...");
            for (String message : messages) {
                System.out.println(user + " sees: " + message);
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    // Send a new message (Only one user can write at a time)
    public void sendMessage(String user, String message) {
        lock.writeLock().lock();
        try {
            System.out.println(user + " is sending a message: " + message);
            messages.add(user + ": " + message);
            System.out.println("Message sent by " + user);
        } finally {
            lock.writeLock().unlock();
        }
    }
}

// Thread for reading chat messages
class ChatReader extends Thread {
    private final ChatHistory chat;
    private final String user;

    public ChatReader(ChatHistory chat, String user) {
        this.chat = chat;
        this.user = user;
    }

    public void run() {
        chat.readMessages(user);
    }
}

// Thread for sending a message
class ChatWriter extends Thread {
    private final ChatHistory chat;
    private final String user;
    private final String message;

    public ChatWriter(ChatHistory chat, String user, String message) {
        this.chat = chat;
        this.user = user;
        this.message = message;
    }

    public void run() {
        chat.sendMessage(user, message);
    }
}

// Main class to test the chat system
public class ChatApp {
    public static void main(String[] args) {
        ChatHistory chat = new ChatHistory();

        // Writers (Sending messages)
        Thread user1 = new ChatWriter(chat, "Alice", "Hey everyone!");
        Thread user2 = new ChatWriter(chat, "Bob", "Hello Alice!");

        // Readers (Reading chat history)
        Thread user3 = new ChatReader(chat, "Charlie");
        Thread user4 = new ChatReader(chat, "Dave");

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}

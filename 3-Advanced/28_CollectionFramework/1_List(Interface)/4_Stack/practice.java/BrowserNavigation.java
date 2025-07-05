// BrowserNavigation.java
import java.util.Stack;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        
        backStack.push("Page 1");
        backStack.push("Page 2");
        backStack.push("Page 3");
        System.out.println("Current Page: " + backStack.peek());
        forwardStack.push(backStack.pop());
        System.out.println("After Back: " + backStack.peek());
    }
}

// 9. Generic Stack Implementation
import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }
}

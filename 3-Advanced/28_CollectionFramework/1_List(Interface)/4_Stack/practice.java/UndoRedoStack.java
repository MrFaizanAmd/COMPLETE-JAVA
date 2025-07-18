// UndoRedoStack.java
import java.util.Stack;

public class UndoRedoStack {
    public static void main(String[] args) {
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();
        
        undoStack.push("Action 1");
        undoStack.push("Action 2");
        undoStack.push("Action 3");
        System.out.println("Undoing: " + undoStack.pop());
        redoStack.push("Action 3");
        System.out.println("Redoing: " + redoStack.pop());
    }
}

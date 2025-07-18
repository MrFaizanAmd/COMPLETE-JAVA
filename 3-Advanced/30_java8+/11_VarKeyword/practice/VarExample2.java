// VarExample2.java - Using var in loops
public class VarExample2 {
    public static void main(String[] args) {
        var numbers = new int[]{1, 2, 3, 4, 5};
        for (var num : numbers) {
            System.out.println(num);
        }
    }
}
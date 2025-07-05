// File: ForLoopPractice.java
public class ForLoopPractice {
    public static void main(String[] args) {
        // 1. Print numbers from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        // 2. Print only even numbers from 1 to 20
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) continue;
            System.out.println(i);
        }

        // 3. Break loop when number equals 7
        for (int i = 1; i <= 10; i++) {
            if (i == 7) break;
            System.out.println(i);
        }

        // 4. Print numbers 10 to 1 in reverse
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }

        // 5. Nested loop: multiplication table (1 to 3)
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }
}

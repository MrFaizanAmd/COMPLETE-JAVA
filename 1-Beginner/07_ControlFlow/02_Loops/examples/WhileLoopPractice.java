// File: WhileLoopPractice.java
public class WhileLoopPractice {
    public static void main(String[] args) {
        // 1. Print numbers from 1 to 10
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // 2. Print only odd numbers from 1 to 15
        i = 1;
        while (i <= 15) {
            if (i % 2 == 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

        // 3. Stop when number equals 5
        i = 1;
        while (i <= 10) {
            if (i == 5) break;
            System.out.println(i);
            i++;
        }

        // 4. Print multiples of 3 from 3 to 30
        i = 3;
        while (i <= 30) {
            System.out.println(i);
            i += 3;
        }

        // 5. Sum numbers until the sum exceeds 50
        i = 1;
        int sum = 0;
        while (sum <= 50) {
            sum += i;
            System.out.println("Number: " + i + ", Sum: " + sum);
            i++;
        }
    }
}

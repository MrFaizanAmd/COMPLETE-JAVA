// File: DoWhileLoopPractice.java
public class DoWhileLoopPractice {
    public static void main(String[] args) {
        // 1. Print numbers from 1 to 5
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        // 2. Print even numbers from 2 to 10
        i = 2;
        do {
            System.out.println(i);
            i += 2;
        } while (i <= 10);

        // 3. Stop when number equals 4
        i = 1;
        do {
            if (i == 4) break;
            System.out.println(i);
            i++;
        } while (i <= 10);

        // 4. Sum numbers from 1 to 10
        i = 1;
        int sum = 0;
        do {
            sum += i;
            System.out.println("Number: " + i + ", Sum: " + sum);
            i++;
        } while (i <= 10);

        // 5. Print reverse countdown from 5 to 1
        i = 5;
        do {
            System.out.println(i);
            i--;
        } while (i >= 1);
    }
}
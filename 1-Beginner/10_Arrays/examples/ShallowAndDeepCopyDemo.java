// File: ShallowCopyDemo.java
// Practice shallow copying of arrays
public class ShallowAndDeepCopyDemo {
    public static void main(String[] args) {
        int[] originalArray1 = {1, 2, 3};
        int[] shallowCopy = originalArray1; // Shallow copy

        // Modify the shallow copy
        shallowCopy[0] = 99;

        // Print both arrays
        System.out.println("Original Array: " + java.util.Arrays.toString(originalArray1));
        System.out.println("Shallow Copy: " + java.util.Arrays.toString(shallowCopy));


        int[] originalArray2 = {1, 2, 3};
        int[] deepCopy = new int[originalArray2.length];

        // Perform deep copy
        for (int i = 0; i < originalArray2.length; i++) {
            deepCopy[i] = originalArray2[i];
        }

        // Modify the deep copy
        deepCopy[0] = 99;

        // Print both arrays
        System.out.println("Original Array: " + java.util.Arrays.toString(originalArray2));
        System.out.println("Deep Copy: " + java.util.Arrays.toString(deepCopy));
    }
}

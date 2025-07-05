// File 1: CallByValueAndReferenceExamples.java

class Box {
    int size;
}

public class CallByValueAndReferenceExamples {

    // Call by Value Example (Primitive Types)
    public void changeValue(int num) {
        num = 10;
    }

    // Call by Reference Example (Objects)
    public void modifyBox(Box b) {
        b.size = 20;
    }

    // Call by Reference Example (Array)
    public void modifyArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2; // Double each element
        }
    }


    public static void main(String[] args) {
        CallByValueAndReferenceExamples examples = new CallByValueAndReferenceExamples();

        // Call by Value Example
        int number = 5;
        System.out.println("Before changeValue: " + number); // Outputs 5
        examples.changeValue(number);
        System.out.println("After changeValue: " + number); // Outputs 5

        // Call by Reference Example (Object)
        Box box = new Box();
        box.size = 10;
        System.out.println("Before modifyBox: " + box.size); // Outputs 10
        examples.modifyBox(box);
        System.out.println("After modifyBox: " + box.size); // Outputs 20

        // Call by Reference Example (Array)
        int[] arr = {1, 2, 3, 4};
        System.out.println("Before modifyArray: " + java.util.Arrays.toString(arr)); // Outputs [1, 2, 3, 4]
        examples.modifyArray(arr);
        System.out.println("After modifyArray: " + java.util.Arrays.toString(arr)); // Outputs [2, 4, 6, 8]

        
    }
}


// 2. Generic Method Example
class Util {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        printArray(names);
    }
}


// 12. Generic Swap Method
class GenericSwap {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String[] words = {"Apple", "Banana", "Cherry"};
        swap(words, 0, 2);
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}


// 14. Generic Reverse Array Method
class ReverseGeneric {
    public static <T> void reverse(T[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        reverse(numbers);
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}

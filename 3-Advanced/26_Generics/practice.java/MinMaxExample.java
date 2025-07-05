
// 11. Generic Min/Max Finder
class MinMax<T extends Comparable<T>> {
    private T[] values;

    public MinMax(T[] values) {
        this.values = values;
    }

    public T min() {
        T min = values[0];
        for (T val : values) {
            if (val.compareTo(min) < 0) {
                min = val;
            }
        }
        return min;
    }

    public T max() {
        T max = values[0];
        for (T val : values) {
            if (val.compareTo(max) > 0) {
                max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 1, 7, 3, 9};
        MinMax<Integer> minMax = new MinMax<>(nums);
        System.out.println("Min: " + minMax.min());
        System.out.println("Max: " + minMax.max());
    }
}

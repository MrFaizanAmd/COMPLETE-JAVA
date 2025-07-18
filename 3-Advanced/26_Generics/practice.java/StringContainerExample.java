
// 4. Generic Interface Example
interface Container<T> {
    void add(T item);
    T get();
}

class StringContainer implements Container<String> {
    private String value;

    public void add(String item) {
        this.value = item;
    }

    public String get() {
        return value;
    }

    public static void main(String[] args) {
        StringContainer sc = new StringContainer();
        sc.add("Hello Generics");
        System.out.println(sc.get());
    }
}

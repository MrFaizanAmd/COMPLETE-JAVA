
// 6. Type Erasure Demonstration
class ErasureExample<T> {
    T obj;

    public ErasureExample(T obj) {
        this.obj = obj;
    }

    public void showType() {
        System.out.println("Type: " + obj.getClass().getName());
    }

    public static void main(String[] args) {
        ErasureExample<String> strEx = new ErasureExample<>("Test");
        strEx.showType();
    }
}

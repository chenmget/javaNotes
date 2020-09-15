package generic.class_demo;

public class Generic<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public Generic(T key) {
        this.key = key;
    }
}

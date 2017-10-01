package list;

public interface StackContainer<T> {

    T poll();

    void push(T value);
}

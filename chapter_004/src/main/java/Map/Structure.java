package Map;

public interface Structure<T,V> extends Iterable<T> {

    boolean insert(T key, V value);
    V get(T key);
    boolean delete(T key);

}

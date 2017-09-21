package generics;

public class SimpleArray<E> {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size){
        this.objects = new Object[size];
    }

    public void add (E value){
        this.objects[index++] = value;
    }

    public E get (int position){
        return (E) this.objects[position];
    }

    public void delete (int position){
        this.objects[position] = null;
        }

    public void update (int position, E value2){
        this.objects[position] = value2;
    }

}

public interface ListInterface<E>{
    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    E set(int i, E element) throws IndexOutOfBoundsException;

    void add(int i,E element) throws IndexOutOfBoundsException, IllegalStateException;

    E remove(int i) throws IndexOutOfBoundsException;
}
import positionallist.Position;

public interface PositionalListInterface<E>{
    int size();

    boolean isEmpty();

    Position<E> first();
    //if it is not empty returns the first position
    //if it is empty returns null

    Position<E> last();
    //if it is not empty returns the last position
    //if it is empty returns null

    Position<E> before(Position<E> p);
    //if p is first returns null

    Position<E> after(Position<E> p);
    //if p is last returns null

    Position<E> addFirst(E element);
    //adds element at the front of the list
    //returns its new position

    Position<E> addLast(E element);
    //adds element at the back of the list
    //returns its new position

    Position<E> addBefore(Position<E> p, E element);
    //adds element before p
    //returns its new position

    Position<E> addAfter(Position<E> p, E element);
    //adds element after p
    //returns its new position

    E set(Position<E> p, E element);
    //replaces the element stored at p
    //returns the old element

    E remove(Position<E> p);
    //removes the element stored at p
    //returns the removed element
}
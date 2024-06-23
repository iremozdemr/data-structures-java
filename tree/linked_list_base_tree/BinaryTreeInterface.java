public interface BinaryTreeInterface<E> extends TreeInterface<E>{
    
    //left child yoksa null döner
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    //right child yoksa null döner
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    //sibling yoksa null döner
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
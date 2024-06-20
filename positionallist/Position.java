package positionallist;

public interface Position<E>{
    
    E getElement() throws IllegalStateException;
    //returns the element stored at this position
    //throws illegal state exception if position no longer valid
}
public interface StackInterface<E>{

    int size();
    //Returns the number of elements in the stack.

    boolean isEmpty();
    //Returns a boolean indicating whether the stack is empty.

    E top();
    //Returnsthetopelementofthestack,withoutremovingit (or null if the stack is empty).

    void push(E element);
    //Adds element to the top of the stack.

    E pop();
    //Removes and returns the top element from the stack (or null if the stack is empty).

    void reverse(Stack<E> stack);

    String toString();

}

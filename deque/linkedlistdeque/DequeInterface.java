//size() O(1)
//isEmpty() O(1)
//first() O(1)
//last() O(1)
//addFirst() O(1)
//addLast() O(1)
//removeFirst() O(1)
//removeLast() O(1)

//space usage array based deque:
//O(N)

//space usage linked list based deque:
//O(n)

//N = size of the array
//n = number of elements in the deque

//n < N

//deque adt:
//size() 
//isEmpty() 
//first() 
//last() 
//addFirst()
//addLast() 
//removeFirst() 
//removeLast() 

//deque java:
//size() 
//isEmpty() 
//getFirst()-peekFirst()
//getLast()-peekLast()
//addFirst()-offerFirst()
//addLast()-offerLast()
//removeFirst()-pollFirst()
//removeLast()-pollLast()

//throws exception:
//getFirst()
//getLast()
//addFirst()
//addLast()
//removeFirst()
//removeLast()

//returns special value:
//peekFirst()
//peekLast()
//offerFirst()
//offerLast()
//pollFirst()
//pollLast()

package deque.linkedlistdeque;

public interface DequeInterface<E>{

    int size();

    boolean isEmpty();

    E first();
    //deque boşsa null döner

    E last();
    //deque boşsa null döner

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();
    //deque boşsa null döner

    E removeLast();
    //deque boşsa null döner
}
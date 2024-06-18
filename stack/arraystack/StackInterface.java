public interface StackInterface<E>{

    int size();

    boolean isEmpty();

    E top();
    //stack boşsa null döner
   
    void push(E element);
    
    E pop();
    //stack boşsa null döner
}

//stack adt:
//size()
//isEmpty()
//push()
//pop()
//top()

//stack java:
//size()
//empty()
//push()
//pop()
//peek()

//farklı olanlar:
//isEmpty()-empty()
//top()-peek()
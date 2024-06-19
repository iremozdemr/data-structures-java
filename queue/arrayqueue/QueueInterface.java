public interface QueueInterface<E>{
    
    int size();

    boolean isEmpty();

    void enqueue(E element);

    E dequeue();
    //queue boşsa null döner

    E first();
    //queue boşsa null döner
}

//queue adt:
//enqueue()
//dequeue()
//first()
//size()
//isEmpty()

//queue java:
//add()-offer()
//remove()-poll()
//element()-peek()
//size()
//isEmpty()

//throws exception:
//add()
//remove()
//element

//returns special value:
//offer()
//poll()
//peek()
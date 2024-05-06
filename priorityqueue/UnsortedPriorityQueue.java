//java.lang.Comparable
//a.compareTo(b)

//java.util.Comparator
//compare(a,b)

//positional list uses doubly linked list
//all methods in positional list -> O(1)

//the space requirement is O(n)

import java.util.Comparator;

public class UnsortedPriorityQueue<K,V>{
    protected class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return key + " " + value;
        }
    }

    private Comparator<K> comparator;
    private PositionalList<Entry<K,V>> list;
    private int size;

    public UnsortedPriorityQueue(Comparator<K> comparator){
        this.comparator = comparator;
    }

    //O(1)
    //returns the number of entries in pq
    public int size(){
        return size;
    }

    //O(1)
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    protected int compare(Entry<K,V> e1,Entry<K,V> e2){
        return comparator.compare(e1.key,e2.key);
    }

    //O(1)
    public Entry<K,V> insert(K key,V value){
        Entry<K,V> entry = new Entry(key,value);
        list.addLast(entry);
        size++;
        return entry;
    }

    //O(n)
    //returns null if the pq is empty
    public Entry<K,V> min(){
        if (isEmpty()) {
            return null;
        }
        else{
            Position<Entry<K,V>> min = list.last();
            while(min != null){
                if(compare(min.getElement(),list.before(min).getElement()) > 0){
                    min = list.before(min);
                }
            }
            return min.getElement();
        }
    }

    //O(n)
    //returns null if the pq is empty
    public Entry<K,V> removeMin(){
        if (isEmpty()) {
            return null;
        }
        else{
            Position<Entry<K,V>> min = list.last();
            while(min != null){
                if(compare(min.getElement(),list.before(min).getElement()) > 0){
                    min = list.before(min);
                }
            }
            Entry<K,V> removed = min.getElement();
            list.remove(min);
            size--;
            return removed;
        }
    }

    public String toString(){
        return list.toString();
    }
}
//java.lang.Comparable
//a.compareTo(b)

//java.util.Comparator
//compare(a,b)

//positional list uses doubly linked list
//all methods in positional list -> O(1)

//the space requirement is O(n)

import java.util.Comparator;

import positionallist.Position;
import positionallist.PositionalList;

public class SortedPriorityQueue<K,V>{
    protected class Entry<K,V>{
        K key;
        V value;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return key + " " + value;
        }
    }

    private Comparator comparator;
    private PositionalList<Entry<K,V>> list;
    private int size;

    public SortedPriorityQueue(Comparator<K> comparator){
        this.comparator = comparator;
        list = new PositionalList<>();
        size = 0;
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
        return comparator.compare(e1.key, e2.key);
    }

    //O(n)
    public Entry<K,V> insert(K key,V value){
        Entry<K,V> entry = new Entry<K,V>(key,value);
        if(isEmpty()){
            list.addFirst(entry);
        }
        else{
            Position<Entry<K,V>> temp = list.last();
            while(temp != null){
                if(compare(temp.getElement(), entry) < 0){
                    list.addAfter(temp, entry);
                    break;
                }
                else if(size == 1){
                    list.addAfter(temp, entry);
                }
                else if(compare(temp.getElement(), entry) > 0){
                    if(temp == list.first()){
                        list.addFirst(entry);
                    }
                }
                temp = list.before(temp);
            }
        }
        size++;
        return entry;
    }

    //O(1)
    //returns null if the pq is empty
    public Entry<K,V> min(){
        if(isEmpty()){
            return null;
        }
        else{
            return list.first().getElement();
        }
    }

    //O(1)
    //returns null if the pq is empty
    public Entry<K,V> removeMin(){
        if(isEmpty()){
            return null;
        }
        else{
            Entry<K,V> entry = list.first().getElement();
            list.remove(list.first());
            size--;
            return entry;
        }
    }

    public String toString(){
        return list.toString();
    }
}
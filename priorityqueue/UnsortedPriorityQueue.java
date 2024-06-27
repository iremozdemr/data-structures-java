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

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{

    protected static class PQEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;

        public PQEntry(K key,V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    private Comparator<K> comparator;
    private PositionalList<Entry<K,V>> list;

    protected UnsortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
        list = new PositionalList<>();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new PQEntry<K,V>(key, value);
        list.addLast(newEntry);

        return newEntry;
    }

    private Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> min = list.first();

        for(Position<Entry<K,V>> position : list.positions()){
            if(compare(position.getElement(), min.getElement()) < 0){
                min = position;
            }
        }

        return min;
    }

    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }
        else{
            return findMin().getElement();
        }
    }

    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        else{
            Position<Entry<K,V>> minPosition = findMin();
            Entry<K,V> minEntry = min();
            list.remove(minPosition);
            return minEntry;
        }
    }

    protected int compare(Entry<K,V> a,Entry<K,V> b){
        return comparator.compare(a.getKey(),b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException{
        try{
            return comparator.compare(key, key) == 0;
        }
        catch(Exception e){
            throw new IllegalArgumentException("incompatible key");
        }
    }
}
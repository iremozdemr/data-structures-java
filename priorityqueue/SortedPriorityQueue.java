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

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{

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

    protected SortedPriorityQueue(Comparator<K> comparator) {
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

        Position<Entry<K,V>> position = list.last();

        while(position != null && compare(newEntry, position.getElement()) < 0){
            position = list.before(position);
        }

        if(position == null){
            list.addFirst(newEntry);
        }
        else{
            list.addAfter(position, newEntry);
        }

        return newEntry;
    }

    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }
        else{
            return list.first().getElement();
        }
    }

    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        else{
            Entry<K,V> result = list.first().getElement();
            list.remove(list.first());
            return result;
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
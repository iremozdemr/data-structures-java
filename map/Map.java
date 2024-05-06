import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

public class Map<K,V> implements MapInterface<K,V>{

    private ArrayList<MapEntry<K,V>> arraylist;

    public Map(){
        arraylist = new ArrayList<>();
    }

    protected class MapEntry<K,V> implements Entry<K,V>{

        private K key;
        private V value;

        public MapEntry(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            this.value = newValue;
            return oldValue;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setkey(K key){
            this.key = key;
        }
 
    }

    @Override
    public int size() {
        int size = arraylist.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public V get(K key) {
        V value = null;
        for(int i = 0; i<size(); i++){
            if(arraylist.get(i).getKey() == key){
                value = arraylist.get(i).getValue();
            }
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        for(int i = 0; i<size(); i++){
            if(arraylist.get(i).getKey() == key){
                oldValue = arraylist.get(i).getValue();
                arraylist.get(i).setValue(value);
            }
        }
        if(oldValue == null){
            MapEntry<K,V> entry = new MapEntry<K,V>(key, value);
            arraylist.add(entry);
        }
        return oldValue;
    }

    @Override
    public V remove(K key) {
        V removedValue = null;
        for(int i = 0; i<size(); i++){
            if(arraylist.get(i).getKey() == key){
                removedValue = arraylist.get(i).getValue();
                arraylist.remove(i);
            }
        }
        return removedValue;
    }

    public String toString(){
        String string = "";
        for(int i = 0; i<size(); i++){
            string = string + arraylist.get(i).getKey() + " " + arraylist.get(i).getValue() + "\n";
        }
        return string;
    }

    protected class EntryIterator implements Iterator<Entry<K,V>>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < size()){
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public MapEntry<K, V> next() {
            if(index >= size()){
                throw new NoSuchElementException();
            }
            else{
                index++;
                return arraylist.get(index-1);
            }
        }
 
    }

    protected class EntryIterable implements Iterable<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }

    }

    protected class KeyIterator implements Iterator<K>{
        EntryIterator entries = new EntryIterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }
    }

    protected class KeyIterable implements Iterable<K>{

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

    }

    protected class ValueIterator implements Iterator<V>,Iterable<V>{
        EntryIterator entries = new EntryIterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
        
    }

    protected class ValueIterable implements Iterable<V>{

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        Iterable<Entry<K, V>> entries = new EntryIterable();
        return entries;
    }

    @Override
    public Iterable<K> keys() {
        Iterable<K> keys = (Iterable<K>) new KeyIterable();
        return keys;
    }

    @Override
    public Iterable<V> values() {
        Iterable<V> values = (Iterable<V>) new ValueIterable();
        return values;
    }
    
}
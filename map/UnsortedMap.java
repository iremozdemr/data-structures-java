//kullanılan methodlar O(n) zaman alır

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

 public class UnsortedMap<K,V> extends AbstractMap<K,V>{

    private ArrayList<MapEntry<K,V>> list = new ArrayList<>();

    public UnsortedMap(){

    }

    @Override
    public int size() {
        return list.size();
    }

    public int findIndex(K key){
        for(int i=0; i<list.size(); i++){
            MapEntry<K,V> myEntry = list.get(i);
            K myKey = myEntry.getKey();

            if(myKey.equals(key)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);

        if(index == -1){
            return null;
        }
        else{
            return list.get(index).getValue();
        }
    }

    @Override
    public V put(K key, V value) {
        int index = findIndex(key);

        if(index == -1){
            MapEntry<K,V> newEntry = new MapEntry<>(key, value);
            list.add(newEntry);
            return null;
        }
        else{
            V oldValue = list.get(index).getValue();
            list.get(index).setValue(value);
            return oldValue;
        }
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);

        if(index == -1){
            return null;
        }
        else{
            V value = list.get(index).getValue();
            list.remove(index);
            return value;
        }
    }

    private class EntryIterator implements Iterator<Entry<K,V>>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            if(index < list.size()){
                return true;
            }
            else{
                return false;
            }
        }

        @SuppressWarnings("unchecked")
        @Override
        public Entry<K, V> next() {
            if(index == list.size()){
                throw new NoSuchElementException();
            }
            else{
                return (Entry<K, V>) list.get(index++);
            }
        }
    }

    private class EntryIterable implements Iterable<Entry<K,V>>{

        @Override
        public Iterator<Entry<K,V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K,V>> entries() {
        return new EntryIterable();
    }
}
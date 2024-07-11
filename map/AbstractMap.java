import java.util.Iterator;

public abstract class AbstractMap<K,V> implements MapInterface<K,V>{
    
    protected static class MapEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;

        public MapEntry(K key,V value){
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

        protected void setKey(K key){
            this.key = key;
        }

        protected void setValue(V value){
            this.value = value;
        }
    }

    private class KeyIterator implements Iterator<K>{

        private Iterator<java.util.Map.Entry<K, V>> entries = entries().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();
        }
    }

    private class KeyIterable implements Iterable<K>{

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    private class ValueIterator implements Iterator<V>{

        private Iterator<java.util.Map.Entry<K, V>> entries = entries().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getValue();
        }
    }

    private class ValueIterable implements Iterable<V>{

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<K> keys(){
        return new KeyIterable();
    }

    public Iterable<V> values(){
        return new ValueIterable();
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
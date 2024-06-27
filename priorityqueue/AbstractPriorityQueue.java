import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueueInterface<K,V>{
    
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

    protected AbstractPriorityQueue(Comparator<K> comparator){
        this.comparator = comparator;
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

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
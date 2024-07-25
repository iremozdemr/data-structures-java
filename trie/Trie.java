//insert() O(n)
//search() O(n)

public class Trie{

    private static class TrieNode{

        TrieNode[] childNodes;
    
        boolean wordEnd;
    
        public TrieNode(){
            wordEnd = false;
    
            childNodes = new TrieNode[alphabetSize];
    
            for(int i=0; i<alphabetSize; i++){
                childNodes[i] = null;
            }
        }
    }

    private static final int alphabetSize = 26;
    private TrieNode root;
    private int wordCount;

    public Trie(){
        root = new TrieNode();
        wordCount = 0;
    }

    public boolean isEmpty(){
        int nullCount = 0;

        for(int i=0; i<alphabetSize; i++){
            if(root.childNodes[i] == null){
                nullCount++;
            }
        }

        if(nullCount == alphabetSize){
            return true;
        }
        else{
            return false;
        }
    }

    public int getWordCount(){
        return wordCount;
    }

    public void insert(String key){
        TrieNode current = root;

        for(int i=0; i<key.length(); i++){
            int index = key.charAt(i) - 'a';

            if(current.childNodes[index] == null){
                current.childNodes[index] = new TrieNode();
            }

            current = current.childNodes[index];
        }
        current.wordEnd = true;
        wordCount++;
    }

    public boolean search(String key){
        TrieNode current = root;

        for(int i=0; i<key.length(); i++){
            int index = key.charAt(i) - 'a';

            if(current.childNodes[index] == null){
                return false;
            }
            else{
                current = current.childNodes[index];
            }
        }

        return current.wordEnd;
    }
}
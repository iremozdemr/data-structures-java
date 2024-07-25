package trie;

public class Trie{

    private class TrieNode{

        TrieNode[] childNodes;
    
        boolean wordEnd;
    
        public TrieNode(){
            wordEnd = false;
    
            childNodes = new TrieNode[26];
    
            for(int i=0; i<26; i++){
                childNodes[i] = null;
            }
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
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
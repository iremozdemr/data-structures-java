public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] strings = { "and", "ant", "do", "geek", "dad", "ball" };

        for(int i=0; i<strings.length; i++){
            trie.insert(strings[i]);
        }

        System.out.println("is empty: " + trie.isEmpty());
        System.out.println("word count: " + trie.getWordCount());

        System.out.println(trie.search("and"));
        System.out.println(trie.search("dna"));
    } 
}
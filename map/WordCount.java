import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");

        System.out.println("please enter the text (type 'q' to finish) : ");

        while(scanner.hasNext()){
            String word = scanner.next().toLowerCase();

            if (word.equals("q")) {
                break;
            }

            Integer count = map.get(word);

            if(count == null){
                count = 1;
            }
            else{
                count = count + 1;
            }

            map.put(word,count);
        }

        int maxCount = 0;
        String maxWord = "";

        for(Entry<String,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            String word = entry.getKey();

            if(count > maxCount){
                maxCount = count;
                maxWord = word;
            }
        }

        System.out.println("the most frequent word is: " + maxWord);
        System.out.println("frequency: " + maxCount);

        scanner.close();
    }
}
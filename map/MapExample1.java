//interface:
//-Map
//-SortedMap

//class:
//-HashMap
//-LinkedHashMap
//-TreeMap

//HashMap:
//hashing kullanır

//LinkedHashMap:
//eklenme sırasına göre entry'leri saklar

//TreeMap:
//key'lerin sırasına göre entry'leri saklar

//map collection interface'inde bulunmaz
//map java.util package'ında bulunur

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class MapExample1 {
    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();

        hashMap.put("vishal",100);
        hashMap.put("sachin",200);
        hashMap.put("vaibhav",300);

        System.out.println("hash map: ");
        for(Entry<String,Integer> entry : hashMap.entrySet()){
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }


        Map<String,Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("vishal",100);
        linkedHashMap.put("sachin",200);
        linkedHashMap.put("vaibhav",300);

        System.out.println("linked hash map: ");
        for(Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }


        Map<String,Integer> treeMap = new TreeMap<>();

        treeMap.put("vishal",100);
        treeMap.put("sachin",200);
        treeMap.put("vaibhav",300);

        System.out.println("tree map: ");
        for(Entry<String,Integer> entry : treeMap.entrySet()){
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }
    }
}
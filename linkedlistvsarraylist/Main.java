import java.util.ArrayList;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {

        long startTime;
        long endTime;

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<1000000; i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        startTime = System.nanoTime();
        linkedList.get(0);
        endTime = System.nanoTime();
        System.out.println("ilk elemente ulasirken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.get(0);
        endTime = System.nanoTime();
        System.out.println("ilk elemente ulasirken arraylist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        linkedList.get(999999);
        endTime = System.nanoTime();
        System.out.println("son elemente ulasirken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.get(999999);
        endTime = System.nanoTime();
        System.out.println("son elemente ulasirken arraylist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        linkedList.get(500000);
        endTime = System.nanoTime();
        System.out.println("ortadaki elemente ulasirken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.get(500000);
        endTime = System.nanoTime();
        System.out.println("ortadaki elemente ulasirken arraylist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        linkedList.remove(0);
        endTime = System.nanoTime();
        System.out.println("ilk elementi silerken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.remove(0);
        endTime = System.nanoTime();
        System.out.println("ilk elementi silerken arraylist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        linkedList.remove(999998);
        endTime = System.nanoTime();
        System.out.println("son elementi silerken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.remove(999998);
        endTime = System.nanoTime();
        System.out.println("son elementi silerken arraylist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        linkedList.add(2);
        endTime = System.nanoTime();
        System.out.println("element eklerken linkedlist icin gecen zaman: " + (endTime-startTime));

        startTime = System.nanoTime();
        arrayList.add(2);
        endTime = System.nanoTime();
        System.out.println("element eklerken arraylist icin gecen zaman: " + (endTime-startTime));
    }
}
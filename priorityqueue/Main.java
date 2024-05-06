import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Comparator<Integer> intComparator1 = Comparator.naturalOrder();
        SortedPriorityQueue<Integer, String> queue1 = new SortedPriorityQueue<>(intComparator1);

        queue1.insert(5, "five");
        System.out.println(queue1);
        queue1.insert(2, "two");
        System.out.println(queue1);
        queue1.insert(8, "eight");
        System.out.println(queue1);
        queue1.insert(1, "one");
        System.out.println(queue1);

        System.out.println("size of the queue: " + queue1.size());
        System.out.println("minimum element: " + queue1.min().value);
        System.out.println("removing minimum element: " + queue1.removeMin().value);
        System.out.println("new minimum element: " + queue1.min().value);


        Comparator<Integer> intComparator2 = Comparator.naturalOrder();
        SortedPriorityQueue<Integer, String> queue2 = new SortedPriorityQueue<>(intComparator2);

        queue2.insert(5, "five");
        System.out.println(queue2);
        queue2.insert(2, "two");
        System.out.println(queue2);
        queue2.insert(8, "eight");
        System.out.println(queue2);
        queue2.insert(1, "one");
        System.out.println(queue2);

        System.out.println("size of the queue: " + queue2.size());
        System.out.println("minimum element: " + queue2.min().value);
        System.out.println("removing minimum element: " + queue2.removeMin().value);
        System.out.println("new minimum element: " + queue2.min().value);
    }
}

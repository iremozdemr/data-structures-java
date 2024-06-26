import java.util.LinkedList;

public class LinkedListExample2 {
    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.offer("a");
        linkedList.offer("b");
        linkedList.offer("c");
        linkedList.offer("d");
        linkedList.offer("e");

        linkedList.add(4, "item");
        linkedList.remove("item");
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        linkedList.addFirst("0");
        linkedList.addLast("6");
        linkedList.removeFirst();
        linkedList.removeLast();
    }
}

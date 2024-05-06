import java.util.LinkedList;

public class LinkedListExample1{
    public static void main(String[] args) {

        LinkedList<String> linkedList1 = new LinkedList<>();

        //linkedlist as a stack
        linkedList1.push("a");
        linkedList1.push("b");
        linkedList1.push("c");
        linkedList1.push("d");
        linkedList1.push("e");

        linkedList1.pop();

        System.out.println(linkedList1.indexOf("a"));

        System.out.println(linkedList1);


        LinkedList<String> linkedList2 = new LinkedList<>();

        //linkedlist as a queue
        linkedList2.offer("a");
        linkedList2.offer("b");
        linkedList2.offer("c");
        linkedList2.offer("d");
        linkedList2.offer("e");

        linkedList2.poll();

        System.out.println(linkedList2.indexOf("a"));

        System.out.println(linkedList2);
    }
}
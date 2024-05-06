public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();

        // adding elements to the list
        myList.addFirst(5);
        myList.addLast(10);
        myList.addFirst(3);
        myList.addLast(15);

        // displaying the list using toString()
        System.out.println("list elements: " + myList.toString());

        // displaying the size of the list
        System.out.println("size of the list: " + myList.size());

        // removing elements from the list
        System.out.println("removed first element: " + myList.removeFirst());
        System.out.println("removed last element: " + myList.removeLast());

        // displaying the updated list using toString()
        System.out.println("list elements after removal: " + myList.toString());

        // displaying the updated size of the list
        System.out.println("size of the list after removal: " + myList.size());
    }
}
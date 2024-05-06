public class Main {
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> myList = new CircularSinglyLinkedList<>();

        // adding elements to the list
        myList.addFirst(5);
        myList.addLast(10);
        myList.addFirst(3);
        myList.addLast(15);

        // displaying the list using toString()
        System.out.println("list elements: " + myList.toString());

        // displaying the first and last elements
        System.out.println("first element: " + myList.first());
        System.out.println("last element: " + myList.last());

        // displaying the size of the list
        System.out.println("size of the list: " + myList.size());

        // removing elements from the list
        System.out.println("removed first element: " + myList.removeFirst());
        System.out.println("removed last element: " + myList.removeLast());

        // displaying the updated list using toString()
        System.out.println("list elements after removal: " + myList.toString());

        // displaying the updated first and last elements
        System.out.println("first element after removal: " + myList.first());
        System.out.println("last element after removal: " + myList.last());

        // displaying the updated size of the list
        System.out.println("size of the list after removal: " + myList.size());

        // rotating the list
        myList.rotate();

        // displaying the list after rotation
        System.out.println("list elements after rotation: " + myList.toString());
    }
}

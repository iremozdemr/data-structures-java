public class Main2 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        myList.addFirst(5);
        myList.addLast(10);
        myList.addFirst(3);
        myList.addLast(15);
        myList.addLast(21);
    
        System.out.println("list elements: " + myList.toString());

        System.out.println("first element: " + myList.first());
        System.out.println("last element: " + myList.last());

        System.out.println("size of the list: " + myList.size());
        
        System.out.println("removed first element: " + myList.removeFirst());
        System.out.println("removed last element: " + myList.removeLast());
        System.out.println("removed first element: " + myList.removeFirst());
        System.out.println("removed last element: " + myList.removeLast());
        System.out.println("removed last element: " + myList.removeLast());
        System.out.println("removed last element: " + myList.removeLast());

        System.out.println("list elements after removal: " + myList.toString());

        System.out.println("first element after removal: " + myList.first());
        System.out.println("last element after removal: " + myList.last());

        System.out.println("size of the list after removal: " + myList.size());
    }
}
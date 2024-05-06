public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList1 = new SinglyLinkedList<>();

        myList1.addFirst(5);
        myList1.addLast(10);
        myList1.addFirst(3);
        myList1.addLast(15);
        myList1.addLast(21);

        System.out.println("list elements: " + myList1.toString());
        
        int index1 = 0; 
        System.out.println("removed element: " + myList1.removeByIndex(index1));
        System.out.println("list elements after removing by index: " + myList1.toString());
        
        int index2 = 11; 
        System.out.println("removed element: " + myList1.removeByIndex(index2));
        System.out.println("list elements after removing by index: " + myList1.toString());
        
        int index3 = 1; 
        System.out.println("removed element: " + myList1.removeByIndex(index3));
        System.out.println("list elements after removing by index: " + myList1.toString());
    
        int index4 = 1; 
        System.out.println("removed element: " + myList1.removeByIndex(index4));
        System.out.println("list elements after removing by index: " + myList1.toString());

        int index5 = 1; 
        System.out.println("removed element: " + myList1.removeByIndex(index5));
        System.out.println("list elements after removing by index: " + myList1.toString());
    
        int index6 = 3; 
        System.out.println("removed element: " + myList1.removeByIndex(index6));
        System.out.println("list elements after removing by index: " + myList1.toString());

        SinglyLinkedList<Integer> myList2 = new SinglyLinkedList<>();

        myList2.addFirst(5);
        myList2.addLast(10);
        myList2.addFirst(3);
        myList2.addLast(15);
        myList2.addLast(21);
    
        System.out.println("list elements: " + myList2.toString());

        System.out.println("first element: " + myList2.first());
        System.out.println("last element: " + myList2.last());

        System.out.println("size of the list: " + myList2.size());

        System.out.println("removed first element: " + myList2.removeFirst());
        System.out.println("removed last element: " + myList2.removeLast());
        System.out.println("removed first element: " + myList2.removeFirst());
        System.out.println("removed last element: " + myList2.removeLast());

        System.out.println("list elements after removal: " + myList2.toString());

        System.out.println("first element after removal: " + myList2.first());
        System.out.println("last element after removal: " + myList2.last());

        System.out.println("size of the list after removal: " + myList2.size());
    }
}
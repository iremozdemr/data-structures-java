//array
//memory is allocated at compile time
//fixed in size
//uses less memory

//linkedlist:
//memory is allocated at run time
//dynamic in size
//uses more memory

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

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
        System.out.println("removed first element: " + myList.removeFirst());
        System.out.println("removed last element: " + myList.removeLast());

        // displaying the updated list using toString()
        System.out.println("list elements after removal: " + myList.toString());

        // displaying the updated first and last elements
        System.out.println("first element after removal: " + myList.first());
        System.out.println("last element after removal: " + myList.last());

        // displaying the updated size of the list
        System.out.println("size of the list after removal: " + myList.size());

        // removing element at index 1
        //System.out.println("removed element at index 1: " + myList.removeByIndex(1));

        // displaying the list after removing element at index 1
        System.out.println("list elements after removing index 1: " + myList.toString());

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();

        // populating the lists
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);

        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(4);
    }
}

//boundary conditions:
//empty data structure
//single element in the data structure
//adding/removing beginning of the data structure
//adding/removing end of the data structure
//working in the middle
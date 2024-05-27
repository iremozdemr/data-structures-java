public class Main2{
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        // test case 1: both lists are empty
        // expected: ""
        DoublyLinkedList<Integer> intersection = list1.findIntersection(list2);
        System.out.println("Test case 1 (Both lists empty): " + intersection); 

        // test case 2: first list is empty, second list is not empty
        // expected: ""
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        intersection = list1.findIntersection(list2);
        System.out.println("Test case 2 (First list empty): " + intersection); 

        // test case 3: second list is empty, first list is not empty
        // expected: ""
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list2 = new DoublyLinkedList<>(); 
        // reset list2 to be empty
        intersection = list1.findIntersection(list2);
        System.out.println("Test case 3 (Second list empty): " + intersection); 

        // test case 4: no intersection
        // expected: ""
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        intersection = list1.findIntersection(list2);
        System.out.println("Test case 4 (No intersection): " + intersection); 

        // test case 5: some intersection
        // expected: 2 3
        list2.addLast(2);
        list2.addLast(3);
        intersection = list1.findIntersection(list2);
        System.out.println("Test case 5 (Some intersection): " + intersection); 

        // test case 6: all elements intersect
        // expected: 1 2 3
        list1 = new DoublyLinkedList<>();
        list2 = new DoublyLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        intersection = list1.findIntersection(list2);
        System.out.println("test case 6 (all elements intersect): " + intersection); 
    }
}
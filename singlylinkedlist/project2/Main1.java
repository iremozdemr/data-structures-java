public class Main1 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        myList.addFirst(5);
        myList.addLast(10);
        myList.addFirst(3);
        myList.addLast(15);
        myList.addLast(21);

        System.out.println("list elements: " + myList.toString());
        
        int index1 = 0; 
        System.out.println("removed element: " + myList.removeByIndex(index1));
        System.out.println("list elements after removing by index: " + myList.toString());
        
        int index2 = 11; 
        System.out.println("removed element: " + myList.removeByIndex(index2));
        System.out.println("list elements after removing by index: " + myList.toString());
        
        int index3 = -1; 
        System.out.println("removed element: " + myList.removeByIndex(index3));
        System.out.println("list elements after removing by index: " + myList.toString());
    
        int index4 = 1; 
        System.out.println("removed element: " + myList.removeByIndex(index4));
        System.out.println("list elements after removing by index: " + myList.toString());

        int index5 = 1; 
        System.out.println("removed element: " + myList.removeByIndex(index5));
        System.out.println("list elements after removing by index: " + myList.toString());
    
        int index6 = 3; 
        System.out.println("removed element: " + myList.removeByIndex(index6));
        System.out.println("list elements after removing by index: " + myList.toString());

        int index7 = 9; 
        System.out.println("removed element: " + myList.removeByIndex(index7));
        System.out.println("list elements after removing by index: " + myList.toString());

        int index8 = 0; 
        System.out.println("removed element: " + myList.removeByIndex(index8));
        System.out.println("list elements after removing by index: " + myList.toString());

        int index9 = 0; 
        System.out.println("removed element: " + myList.removeByIndex(index9));
        System.out.println("list elements after removing by index: " + myList.toString());
    }
}
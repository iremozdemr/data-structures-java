public class Main3 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());

        myList.addFirst(5);

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());

        myList.addLast(10);

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());

        myList.addFirst(3);

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());

        myList.addLast(15);

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());

        myList.addLast(21);

        System.out.println("size(): " + myList.size());
        System.out.println("findSize(): " + myList.findSize());
        System.out.println("findSizeRecursive(): " + myList.findSizeRecursive());
    }
}
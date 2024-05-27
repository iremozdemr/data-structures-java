public class Main3{
    public static void main(String[] args) {
        testRotateEmptyList();
        testRotateSingleElementList();
        testRotateWithZeroCount();
        testRotatePositiveCount();
        testRotateNegativeCount();
        testRotateLargePositiveCount();
        testRotateLargeNegativeCount();
    }

    public static void testRotateEmptyList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.rotate(3);
        if (list.isEmpty()) {
            System.out.println("testRotateEmptyList passed");
        } else {
            System.out.println("testRotateEmptyList failed");
        }
    }

    public static void testRotateSingleElementList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.rotate(2);
        if (" 1".equals(list.toString())) {
            System.out.println("testRotateSingleElementList passed");
        } else {
            System.out.println("testRotateSingleElementList failed");
        }
    }

    public static void testRotateWithZeroCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.rotate(0);
        if (" 1 2 3".equals(list.toString())) {
            System.out.println("testRotateWithZeroCount passed");
        } else {
            System.out.println("testRotateWithZeroCount failed");
        }
    }

    public static void testRotatePositiveCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.rotate(2);
        if (" 3 4 1 2".equals(list.toString())) {
            System.out.println("testRotatePositiveCount passed");
        } else {
            System.out.println("testRotatePositiveCount failed");
        }
    }

    public static void testRotateNegativeCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.rotate(-1);
        if (" 2 3 4 1".equals(list.toString())) {
            System.out.println("testRotateNegativeCount passed");
        } else {
            System.out.println("testRotateNegativeCount failed");
        }
    }

    public static void testRotateLargePositiveCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.rotate(6); 
        if (" 3 4 1 2".equals(list.toString())) {
            System.out.println("testRotateLargePositiveCount passed");
        } else {
            System.out.println("testRotateLargePositiveCount failed");
        }
    }

    public static void testRotateLargeNegativeCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.rotate(-5); 
        if (" 2 3 4 1".equals(list.toString())) {
            System.out.println("testRotateLargeNegativeCount passed");
        } else {
            System.out.println("testRotateLargeNegativeCount failed");
        }
    }
}
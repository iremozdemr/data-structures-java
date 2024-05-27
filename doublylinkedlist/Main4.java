public class Main4{

    public static void main(String[] args) {
        testMergeListsEmptyLists();
        testMergeListsWithOneEmptyList();
        testMergeListsWithNoCommonElements();
        testMergeListsWithCommonElements();
    }

    public static void testMergeListsEmptyLists() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> mergedList = list1.mergeLists(list1, list2);
        if (mergedList.isEmpty()) {
            System.out.println("testMergeListsEmptyLists passed");
        } else {
            System.out.println("testMergeListsEmptyLists failed");
        }
    }

    public static void testMergeListsWithOneEmptyList() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.addLast(1);
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> mergedList1 = list1.mergeLists(list1, list2);
        if (mergedList1.toString().equals(" 1")) {
            System.out.println("testMergeListsWithOneEmptyList passed");
        } else {
            System.out.println("testMergeListsWithOneEmptyList failed");
        }

        DoublyLinkedList<Integer> list3 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list4 = new DoublyLinkedList<>();
        list4.addLast(2);
        DoublyLinkedList<Integer> mergedList2 = list3.mergeLists(list3, list4);
        if (mergedList2.toString().equals(" 2")) {
            System.out.println("testMergeListsWithOneEmptyList passed");
        } else {
            System.out.println("testMergeListsWithOneEmptyList failed");
        }
    }

    public static void testMergeListsWithNoCommonElements() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        DoublyLinkedList<Integer> mergedList = list1.mergeLists(list1, list2);
        if (mergedList.toString().equals(" 1 2 3 4 5 6")) {
            System.out.println("testMergeListsWithNoCommonElements passed");
        } else {
            System.out.println("testMergeListsWithNoCommonElements failed");
        }
    }

    public static void testMergeListsWithCommonElements() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        DoublyLinkedList<Integer> mergedList = list1.mergeLists(list1, list2);
        if (mergedList.toString().equals(" 1 2 3 3 4 5")) {
            System.out.println("testMergeListsWithCommonElements passed");
        } else {
            System.out.println("testMergeListsWithCommonElements failed");
        }
    }
}
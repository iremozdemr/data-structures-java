public class Main4 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

        myList.addLast(10);
        myList.addLast(20);
        myList.addLast(30);
        myList.addLast(40);
        myList.addLast(50);
        myList.addLast(60);
        myList.addLast(70);

        myList.swapNodes(10,70);
        System.out.println("list: " + myList);

        myList.swapNodes(70,10);
        System.out.println("list: " + myList);

        myList.swapNodes(10,20);
        System.out.println("list: " + myList);

        myList.swapNodes(20,10);
        System.out.println("list: " + myList);

        myList.swapNodes(20,30);
        System.out.println("list: " + myList);

        myList.swapNodes(30,20);
        System.out.println("list: " + myList);

        myList.swapNodes(60,70);
        System.out.println("list: " + myList);

        myList.swapNodes(70,60);
        System.out.println("list: " + myList);
    }
}
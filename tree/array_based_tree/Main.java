package array_based_tree;

public class Main {
    public static void main(String[] args) throws Exception {
        // create a binary tree with capacity 15
        BinaryTree<Integer> tree = new BinaryTree<>(15);

        // add elements to the tree
        tree.add(0, 1);
        tree.add(1, 2);
        tree.add(2, 4);
        tree.add(3, 3);
        tree.add(4, 5);
        tree.add(5, 7);
        tree.add(6, 8);

        // print the tree structure
        System.out.println("tree structure:");
        System.out.println(tree);

        // test root, parent, left, right methods
        System.out.println("root element: " + tree.root());
        System.out.println("parent of index 3: " + tree.parent(3));
        System.out.println("left child of index 1: " + tree.left(1));
        System.out.println("right child of index 1: " + tree.right(1));

        // test remove method
        System.out.println("removing element at index 3: " + tree.remove(3));
        System.out.println("tree after removal:");
        System.out.println(tree);
    }
}
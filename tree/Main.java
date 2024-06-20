import positionallist.Position;

public class Main {
    public static void main(String[] args) {
        // creating an instance of binary tree and renamed it to 'tree'
        BinaryTree<Integer> tree = new BinaryTree<>();

        // adding elements to the tree
        Position<Integer> root = (Position<Integer>) tree.addRoot(1);
        Position<Integer> leftChild = (Position<Integer>) tree.addLeft(root, 2);
        Position<Integer> rightChild = (Position<Integer>) tree.addRight(root, 3);
        Position<Integer> leftGrandChild = (Position<Integer>) tree.addLeft(leftChild, 4);
        Position<Integer> rightGrandChild = (Position<Integer>) tree.addRight(leftChild, 5);

        // testing various methods
        System.out.println("size of the tree: " + tree.size()); // expected output: 5

        System.out.println("root element: " + tree.root().getElement()); // expected output: 1

        System.out.println("left child of root: " + tree.left(root).getElement()); // expected output: 2

        System.out.println("right child of root: " + tree.right(root).getElement()); // expected output: 3

        System.out.println("parent of left child of root: " + tree.parent(leftChild).getElement()); // expected output: 1

        System.out.println("sibling of right child of root: " + tree.sibling(rightChild).getElement()); // expected output: 2

        System.out.println("number of children of left child of root: " + tree.numChildren(leftChild)); // expected output: 2

        System.out.print("children of left child of root: ");
        for (Position<Integer> child : tree.children(leftChild)) {
            System.out.print(child.getElement() + " "); // expected output: 4 5
        }
        System.out.println();

        System.out.println("is the root an internal node? " + tree.isInternal(root)); // expected output: true

        System.out.println("is the left grandchild of root an external node? " + tree.isExternal(leftGrandChild)); // expected output: true

        System.out.println("setting element of rightchild to 10: " + tree.set(rightChild, 10)); // expected output: 3

        System.out.println("element removed: " + tree.remove(leftGrandChild)); // expected output: 4

        // testing attach method
        Position<Integer> child = (Position<Integer>) tree.addLeft(leftGrandChild, 1);
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        Position<Integer> root1 = tree1.addRoot(10);
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        Position<Integer> root2 = tree2.addRoot(20);
        tree.attach(child, tree1, tree2);
        System.out.println("size of the combined tree after attach: " + tree.size()); // expected output: 8

        // testing traversal methods
        BinaryTree<Integer> traversal = new BinaryTree<>();
        Position<Integer> rootT = traversal.addRoot(5);
        Position<Integer> leftChildT = traversal.addLeft(rootT, 3);
        Position<Integer> rightChildT = traversal.addRight(rootT, 8);
        Position<Integer> leftGrandChildT = traversal.addLeft(leftChildT, 2);
        Position<Integer> rightGrandChildT = traversal.addRight(leftChildT, 4);
        Position<Integer> leftGreatGrandChildT = traversal.addLeft(leftGrandChildT, 1);
        Position<Integer> rightGreatGrandChildT = traversal.addRight(rightGrandChildT, 7);
        Position<Integer> rightGreatGrandChildChildT = traversal.addRight(rightGreatGrandChildT, 6);
        Position<Integer> rightChildChildT = traversal.addRight(rightChildT, 9);
        
        System.out.println("inorder traversal: ");
        traversal.inorder(rootT);
        System.out.println("");
        System.out.println("preorder traversal: ");
        traversal.preorder(rootT); 
        System.out.println("");
        System.out.println("postorder traversal: ");
        traversal.postorder(rootT); 
        System.out.println("");
    }
}
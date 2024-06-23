public class Main1 {
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>();

        // test isEmpty and addRoot methods
        System.out.println("tree is empty: " + tree.isEmpty());
        Position<String> root = tree.addRoot("root");
        System.out.println("tree is empty after adding root: " + tree.isEmpty());
        System.out.println("root of tree: " + root.getElement());

        // add left and right children to the root
        Position<String> leftChild = tree.addLeft(root, "left child");
        Position<String> rightChild = tree.addRight(root, "right child");
        System.out.println("left child of root: " + tree.left(root).getElement());
        System.out.println("right child of root: " + tree.right(root).getElement());

        // add children to the left child
        Position<String> leftLeftChild = tree.addLeft(leftChild, "left-left child");
        Position<String> leftRightChild = tree.addRight(leftChild, "left-right child");
        System.out.println("left child of left child: " + tree.left(leftChild).getElement());
        System.out.println("right child of left child: " + tree.right(leftChild).getElement());

        // add a right child to the right child of the root
        Position<String> rightRightChild = tree.addRight(rightChild, "right-right child");
        System.out.println("right child of right child: " + tree.right(rightChild).getElement());

        // test traversal methods
        System.out.print("inorder traversal: ");
        tree.inorder(tree.root());
        System.out.println();

        System.out.print("preorder traversal: ");
        tree.preorder(tree.root());
        System.out.println();

        System.out.print("postorder traversal: ");
        tree.postorder(tree.root());
        System.out.println();

        // Test size and height methods
        System.out.println("size of tree: " + tree.size());
    
        // Test other operations
        System.out.println("parent of left child: " + tree.parent(leftChild).getElement());
        System.out.println("sibling of left child: " + tree.sibling(leftChild).getElement());
        System.out.println("number of children of root: " + tree.numChildren(root));

        // Test setting and removing nodes
        System.out.println("setting left child element to 'updated left child'");
        tree.set(leftChild, "updated left child");
        System.out.println("updated left child: " + tree.left(root).getElement());

        System.out.println("removing left-left child");
        tree.remove(leftLeftChild);
        System.out.println("left child of left child after removal: " + tree.left(leftChild));

        // Test attach method
        BinaryTree<String> subtree1 = new BinaryTree<>();
        BinaryTree<String> subtree2 = new BinaryTree<>();
        Position<String> subtreeRoot1 = subtree1.addRoot("subtree1 root");
        subtree1.addLeft(subtreeRoot1, "subtree1 left child");
        subtree1.addRight(subtreeRoot1, "subtree1 right child");
        Position<String> subtreeRoot2 = subtree2.addRoot("subtree2 root");
        subtree2.addLeft(subtreeRoot2, "subtree2 left child");
        subtree2.addRight(subtreeRoot2, "subtree2 right child");

        System.out.println("attaching subtrees to right-right child of root");
        tree.attach(rightRightChild, subtree1, subtree2);

        System.out.print("inorder traversal after attaching subtrees: ");
        tree.inorder(tree.root());
        System.out.println();
    }
}
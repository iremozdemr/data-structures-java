public class Main1{
    public static void main(String[] args) {
        //create a binary tree
        BinaryTree<Integer> tree = new BinaryTree<>();

        //check if the tree is empty
        if (tree.isEmpty()) {
            System.out.println("the tree is currently empty");
        }

        //add root node
        Position<Integer> root = tree.addRoot(1);
        System.out.println("tree state:\n" + tree);

        //add left child
        Position<Integer> leftChild = tree.addLeft(root, 2);
        System.out.println("left child added\ntree state:\n" + tree);

        //add right child
        Position<Integer> rightChild = tree.addRight(root, 3);
        System.out.println("right child added\ntree state:\n" + tree);

        //add left child's left child
        Position<Integer> leftLeftChild = tree.addLeft(leftChild, 4);
        System.out.println("left child's left child added\ntree state:\n" + tree);

        //add right child's right child
        Position<Integer> rightRightChild = tree.addRight(rightChild, 5);
        System.out.println("right child's right child added\ntree state:\n" + tree);

        //check if the tree is not empty
        if (!tree.isEmpty()) {
            System.out.println("the tree is not empty.");
        }

        //check the size of the tree
        System.out.println("tree size: " + tree.size());

        //verify the root node
        if (tree.root() == root) {
            System.out.println("the root node is correct");
        } else {
            System.out.println("the root node is incorrect");
        }

        //verify the parent of the left child
        if (tree.parent(leftChild) == root) {
            System.out.println("the parent of the left child is correct");
        } else {
            System.out.println("the parent of the left child is incorrect");
        }

        //verify the sibling of the right child
        if (tree.sibling(rightChild) == leftChild) {
            System.out.println("the sibling of the right child is correct");
        } else {
            System.out.println("the sibling of the right child is incorrect");
        }

        //print the final tree
        System.out.println("final tree state:\n" + tree);

        //remove a node
        tree.remove(leftLeftChild);
        System.out.println("leftleft node removed\ntree state:\n" + tree);
    }
}
public class Main3 {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Position<Integer> root = tree.addRoot(1);
        Position<Integer> rootLeft = tree.addLeft(root,2);
        Position<Integer> rootRight = tree.addRight(root,3);
        Position<Integer> rootLeftLeft = tree.addLeft(rootLeft,4);
        Position<Integer> rootLeftRight = tree.addRight(rootLeft,5);

        System.out.print("the diameter of given binary tree is: ");
        System.out.println(tree.diameter());
    }
}
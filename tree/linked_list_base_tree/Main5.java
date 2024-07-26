public class Main5 {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Position<Integer> root = tree.addRoot(1);
        Position<Integer> rootLeft = tree.addLeft(root,2);
        Position<Integer> rootRight = tree.addRight(root,3);
        Position<Integer> rootLeftLeft = tree.addLeft(rootLeft,4);
        Position<Integer> rootLeftRight = tree.addRight(rootLeft,5);
        Position<Integer> rootLeftLeftLeft = tree.addLeft(rootLeftLeft,7);

        System.out.print("verilen node'un ustunde olan node'lar: ");
        tree.printAncestors(rootLeftLeftLeft);
        System.out.println();
    }
}
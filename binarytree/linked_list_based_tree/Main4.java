public class Main4 {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Position<Integer> root = tree.addRoot(1);
        Position<Integer> rootLeft = tree.addLeft(root,2);
        Position<Integer> rootRight = tree.addRight(root,3);
        Position<Integer> rootLeftLeft = tree.addLeft(rootLeft,4);
        Position<Integer> rootLeftRight = tree.addRight(rootLeft,5);
        Position<Integer> rootRightLeft = tree.addLeft(rootRight,8);

        System.out.print("root'a k uzakliktaki node'lar: ");
        tree.printNodesAtKDistance(root, 2);
        System.out.println();
    }
}
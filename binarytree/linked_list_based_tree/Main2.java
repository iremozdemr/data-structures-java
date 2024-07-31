public class Main2{
    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<>();
        Position<String> root = tree.addRoot("root");
        Position<String> left = tree.addLeft(root, "left");
        Position<String> right = tree.addRight(root, "right");
        Position<String> leftLeft = tree.addLeft(left, "left-left");
        Position<String> leftRight = tree.addRight(left, "left-right");
        Position<String> rightLeft = tree.addLeft(right, "right-left");
        Position<String> rightRight = tree.addRight(right, "right-right");

        System.out.println("inorder traversal:");
        for (Position<String> p : tree.inorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        System.out.println("preorder traversal:");
        for (Position<String> p : tree.preorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        System.out.println("postorder traversal:");
        for (Position<String> p : tree.postorder()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();

        System.out.println("breadth first traversal:");
        for (Position<String> p : tree.breadthfirst()) {
            System.out.print(p.getElement() + " ");
        }
        System.out.println();
    }
}
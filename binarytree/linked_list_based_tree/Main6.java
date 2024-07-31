public class Main6 {
    public static void main(String[] args) {
        BinaryTree<Integer> mainTree = new BinaryTree<>();

        Position<Integer> mainRoot = mainTree.addRoot(26);
        Position<Integer> mainRootLeft = mainTree.addLeft(mainRoot,10);
        Position<Integer> mainRootRight = mainTree.addRight(mainRoot,3);
        Position<Integer> mainRootLeftLeft = mainTree.addLeft(mainRootLeft,4);
        Position<Integer> mainRootLeftRight = mainTree.addRight(mainRootLeft,6);
        Position<Integer> mainRootLeftLeftRight = mainTree.addRight(mainRootLeftLeft,30);

        BinaryTree<Integer> subTree = new BinaryTree<>();

        Position<Integer> subRoot = subTree.addRoot(10);
        Position<Integer> subRootLeft = subTree.addLeft(subRoot,4);
        Position<Integer> subRootRight = subTree.addRight(subRoot,6);
        Position<Integer> subRootLeftRight = subTree.addRight(subRootLeft,30);

        System.out.println("is subtree: " + mainTree.isSubtree(subRoot,mainRoot));
    }
}
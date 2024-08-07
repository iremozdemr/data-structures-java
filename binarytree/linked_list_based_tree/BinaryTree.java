//binary tree türleri:

//children sayısına göre:
//-full
//-degenerate(pathological)
//-skewed

//seviyelerin tamamlanmasına göre:
//-complete
//-perfect
//-balanced

//node değerlerine göre:
//-search
//-avl
//-red black
//b
//b+
//segment

//unlabelled binary tree:
//node'lar isimlendirilmemiştir
//n node varsa:
//T(n) = (2n)! / (n+1)!.n! farklı binary tree oluşturulabilir

//unlabelled binary tree için hesaplamalar:
//n'th catalan numbers: 1,1,2,5,14,42,132...
//T(0) = 1
//T(1) = 1
//T(2) = 2
//T(3) = T(0)*T(2) + T(2)*T(0) + T(1).T(1)
//T(4) = T(0)*T(3) + T(3)*T(0) + T(1)*T(2) + T(2)*T(1)

//labeled binary tree:
//node'lar isimlendirilmiştir
//n node varsa
//T(n) = [(2n)! / (n+1)!.n!] . n! farklı binary tree oluşturulabilir

//binary tree
//tüm elementlerin 0,1,2 çocuğu olabilir

//complete 
//son seviye hariç tüm seviyeler tamamen dolu

//proper = full
//tüm elementlerin 0,2 çocuğu olabilir

//improper = proper olmayan

//desicion tree  
//proper tree olmak zorundadır

//perfect = full(proper) + complete

//root = level 0
//left child of root = level 1
//right child of root = level 1

//level d en fazla 2^d node'a sahip olabilir

//binary tree:
//h+1 ≤ n ≤ 2^(h+1)−1
//1 ≤ number of external nodes ≤ 2^h
//h ≤ number of internal nodes ≤ 2^h - 1
//log(n+1)-1 ≤ h ≤ n-1

//full(proper) binary tree:
//2h+1 ≤ n ≤ 2^(h+1)−1
//h+1 ≤ number of external nodes ≤ 2^h
//h ≤ number of internal nodes ≤ 2^h - 1
//log(n+1)-1 ≤ h ≤ (n-1)/2
//number of external nodes = number of internal nodes + 1

//size() O(1)
//isEmpty() O(1)
//root() O(1)
//parent() O(1)
//left() O(1)
//right() O(1)
//sibling() O(1)
//children() O(1)
//numChildren() O(1)
//isInternal() O(1)
//isExternal() O(1)
//isRoot() O(1)
//addRoot() O(1)
//addLeft() O(1)
//addRight() O(1)
//set() O(1)
//attach() O(1)
//remove() O(1)

//depth() O(n)
//height1() O(n)
//height2() O(n^2)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> extends AbstractBinaryTree<E>{

    private static class Node<E> implements Position<E>{
        private E data;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E data,Node<E> parent,Node<E> left,Node<E> right){
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() {
            return data;
        }
    }

    private Node<E> root;
    private int size;

    public BinaryTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Position<E> root(){
        if(isEmpty()){
            return null;
        }
        else{
            return (Position<E>) root;
        }
    }

    //left child yoksa null döner
    public Position<E> left(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            return (Position<E>) node.left;
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    //right child yoksa null döner
    public Position<E> right(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            return (Position<E>) node.right;
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    //p = root ise null döner
    public Position<E> parent(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            if(node == root){
                return null;
            }
            else{
                return (Position<E>) node.parent;
            }
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    //sibling yoksa null döner
    public Position<E> sibling(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node == root){
            return null;
        }
        else{
            Node<E> parent = node.parent;
            if(parent.left == node){
                return (Position<E>) parent.right;
            }
            if(parent.right == node){
                return (Position<E>) parent.left;
            }
        }
        return null;
    }

    public int numChildren(Position<E> p){
        int number = 0;
        Node<E> node = (Node<E>) p;
        if(node.left != null){
            number++;
        }
        if(node.right != null){
            number++;
        }
        return number;
    }

    public Iterable<Position<E>> children(Position<E> p){
        ArrayList<Position<E>> list = new ArrayList<>();
        Node<E> node = (Node<E>) p;
        if(node.left != null){
            list.add((Position<E>) node.left);
        }
        if(node.right != null){
            list.add((Position<E>) node.right);
        }
        return list;
    }

    //depth = p hariç p'nin ancestor sayısı
    //depth of p = depth of the parent + 1
    //depth of root = 0
    //O(dp + 1)
    //O(n)
    //n = size of tree
    public int depth(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(isRoot(p)){
            return 0;
        }
        else{
            return depth(node.parent) + 1;
        }
    }

    //height of p = height of children + 1
    //O(cp + 1)
    //O(∑p(cp +1))
    //O(n+∑p cp)
    //O(n)
    //cp = number of children of p
    public int height1(Position<E> p){
        int maxHeight = 0;

        for(Position<E> c : children(p)){
            if(height1(c) > maxHeight){
                maxHeight = height1(c) + 1;
            }
        }

        return maxHeight;
    }

    //height = maximum depth
    //O(n + ∑p∈L(dp + 1))
    //O(n^2)
    public int height2(){
        int maxDepth = 0;

        for(Position<E> p : positions()){
            if(isExternal(p)){
                if(depth(p) > maxDepth){
                    maxDepth = depth(p);
                }
            }
        }

        return maxDepth;
    }

    //eğer node = null değilse
    //height = left subtree ve right subtree'nin max'ı + 1
    public int height3(Node<E> node){
        if(node == null){
            return 0;
        }
        else{
            int leftHeight = height3(node.left);
            int rightHeight = height3(node.left);
            int max = Math.max(leftHeight,rightHeight);

            int height = max+1;
            return height;
        }
    }

    public boolean isRoot(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node == root){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isInternal(Position<E> p){
        if(numChildren(p) > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isExternal(Position<E> p){
        if(numChildren(p) == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Position<E> addRoot(E element) throws IllegalArgumentException{
        if(isEmpty()){
            Node<E> newRoot = new Node<E>(element,null,null,null);
            root = newRoot;
            size++;
            return (Position<E>) newRoot;
        }
        else{
            throw new IllegalStateException("tree is not empty");
        }
    }

    public Position<E> addLeft(Position<E> p,E element) throws IllegalArgumentException{
        Node<E> node = (Node<E>) p;
        Node<E> newNode = new Node<E>(element,null,null,null);
        if(node.left == null){
            node.left = newNode;
            newNode.parent = node;
            size++;
            return (Position<E>) newNode;
        }
        else{
            throw new IllegalStateException("p already has a left child");
        }
    }

    public Position<E> addRight(Position<E> p,E element) throws IllegalArgumentException{
        Node<E> node = (Node<E>) p;
        Node<E> newNode = new Node<E>(element,null,null,null);
        if(node.right == null){
            node.right = newNode;
            newNode.parent = node;
            size++;
            return (Position<E>) newNode;
        }
        else{
            throw new IllegalStateException("p already has a right child");
        }
    }

    public E set(Position<E> p,E element) throws IllegalArgumentException{
        if(p != null){
            Node<E> node = (Node<E>) p;
            E removed = node.data;
            node.data = element;
            return removed;
        }
        else{
            return null;
        }
    }

    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = (Node<E>) p;
        E removed = null;
        int children = numChildren(p);
        if(children == 0){
            removed = node.data;
            node = null;
        }
        else if(children == 2){
            throw new IllegalArgumentException("p has two children");
        }
        else if(node.left != null){
            removed = node.data;
            E leftData = node.left.data;
            node.data = leftData;
            node.left = null;
        }
        else{
            removed = node.data;
            E rightData = node.right.data;
            node.data = rightData;
            node.right = null;
        }
        return removed;
    }

    public void attach(Position<E> p,BinaryTree<E> t1,BinaryTree<E> t2) throws IllegalArgumentException{
        Node<E> node = (Node<E>) p;
        if(isExternal(node)){
            this.size = size + t1.size + t2.size;
            if(t1.isEmpty() == false){
                node.left = t1.root;
                t1.size = 0;
                t1 = null;
            }
            if(t2.isEmpty() == false){
                node.right = t2.root;
                t2.size = 0;
                t2 = null;
            }
        }
        else{
            throw new IllegalArgumentException("p must be a leaf");
        }
    }

    //bunlardan maximum olanı döner
    //1-diameter of right subtree
    //2-diameter of left subtree
    //3-height of left subtree + height of right subtree + 1
    public int diameterHelper(Node<E> root){
        if(root == null){
            return 0;
        }
        else{
            int leftHeight = height3(root.left);
            int rightHeight = height3(root.right);
            int sumHeight = leftHeight+rightHeight+1;

            int leftDiameter = diameterHelper(root.left);
            int rightDiameter = diameterHelper(root.right);
            int maxDiameter = Math.max(leftDiameter,rightDiameter);

            int max = Math.max(maxDiameter,sumHeight);

            return max;
        }
    }

    public int diameter(){
        return diameterHelper(root);
    }

    public boolean isSubtree(Position<E> sub,Position<E> main){
        Node<E> subNode = (Node<E>) sub;
        Node<E> mainNode = (Node<E>) main;

        if(subNode == null && mainNode == null){
            return true;
        }
        else if(subNode == null && mainNode != null){
            return true;
        }
        else if(mainNode == null){
            return false;
        }
        else{
            if(areIdentical(subNode,mainNode)){
                return true;
            }
            else{
                boolean statement1 = isSubtree(subNode, mainNode.left);
                boolean statement2 = isSubtree(subNode, mainNode.right);

                return statement1 || statement2;
            }
        }
    }

    public boolean areIdentical(Position<E> position1,Position<E> position2){
        Node<E> node1 = (Node<E>) position1;
        Node<E> node2 = (Node<E>) position2;

        if(node1 == null && node2 == null){
            return true;
        }
        else if(node1 == null && node2 != null){
            return false;
        }
        else if(node1 != null && node2 == null){
            return false;
        }
        else{
            if(node1.data == node2.data){
                boolean statement1 = areIdentical(node1.left,node2.left);
                boolean statement2 = areIdentical(node1.right,node2.right);
                return statement1 && statement2;
            }
            else{
                return false;
            }
        }
    }

    public void printNodesAtKDistance(Position<E> root,int k){
        Node<E> node = (Node<E>) root;
        if(node == null){
            return;
        }
        else if(k < 0){
            return;
        }
        else if(k == 0){
            System.out.print(node.data);
            return;
        }
        else{
            printNodesAtKDistance(node.left,k-1);
            printNodesAtKDistance(node.right,k-1);
        }
    }

    public void printAncestors(Position<E> position){
        Node<E> node = (Node<E>) position;

        if(node == root){
            return;
        }
        else if(node == null){
            return;
        }
        else{
            System.out.print(node.parent.data + " ");
            printAncestors(node.parent);
        }
    }

    public String toString() {
        if (isEmpty()) return "Tree is empty";
    
        StringBuilder sb = new StringBuilder();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean hasNextLevel = false;
            for (int i = 0; i < levelSize; i++) {
                Node<E> node = queue.poll();
                if (node != null) {
                    sb.append(node.data).append(" ");
                    if (node.left != null || node.right != null) {
                        hasNextLevel = true;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append(". ");
                    queue.add(null);
                    queue.add(null);
                }
            }
            sb.append("\n");
            if (!hasNextLevel) break; // Stop if next level has no nodes
        }
    
        return sb.toString();
    } 
    
    private class ElementIterator implements Iterator<E>{

        Iterator<Position<E>> iterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next().getElement();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return preorder();
    }

    public Iterable<Position<E>> inorder(){
        ArrayList<Position<E>> list = new ArrayList<>();

        if(!isEmpty()){
            inorderHelper(list, root);
        }

        return list;
    }

    private void inorderHelper(ArrayList<Position<E>> list,Position<E> p){
        if(left(p) != null){
            inorderHelper(list, left(p));
        }

        list.add(p);

        if(right(p) != null){
            inorderHelper(list, right(p));
        }
    }

    public Iterable<Position<E>> preorder(){
        ArrayList<Position<E>> list = new ArrayList<>();

        if(!isEmpty()){
            preorderHelper(list, root);
        }

        return list;
    }

    private void preorderHelper(ArrayList<Position<E>> list,Position<E> p){
        if(p != null){
            list.add(p);

            for(Position<E> c : children(p)){
                preorderHelper(list, c);
            }
        }
    }

    public Iterable<Position<E>> postorder(){
        ArrayList<Position<E>> list = new ArrayList<>();

        if(!isEmpty()){
            postorderHelper(list, root);
        }

        return list;
    }

    private void postorderHelper(ArrayList<Position<E>> list,Position<E> p){
        if(p != null){
            for(Position<E> c : children(p)){
                postorderHelper(list, c);
            }

            list.add(p);
        }
    }

    public Iterable<Position<E>> breadthfirst(){
        ArrayList<Position<E>> list = new ArrayList<>();
        if(isEmpty() == false){
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(root);

            while(queue.isEmpty() == false){
                Node<E> node = queue.poll();
                list.add(node);

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return list;
    }

    /* 
    public void inorder(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node != null){
            if(node.left != null){
                inorder(node.left);
            }
            System.out.print(node.data + " ");
            if(node.right != null){
                inorder(node.right);
            }
        }
    }

    public void preorder(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node != null){
            System.out.print(node.data + " ");
            if(node.left != null){
                preorder(node.left);
            }
            if(node.right != null){
                preorder(node.right);
            }
        }
    }

    public void postorder(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node != null){
            if(node.left != null){
                postorder(node.left);
            }
            if(node.right != null){
                postorder(node.right);
            }
            System.out.print(node.data + " ");
        }
    }
    */
}
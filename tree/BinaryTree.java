//binary tree
//tüm elementlerin 0,1,2 çocuğu olabilir

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

import java.util.ArrayList;
import java.util.Iterator;

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
    //O(n) = O(dp + 1)
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

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positions'");
    }
}
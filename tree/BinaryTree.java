import java.util.ArrayList;

//hierarchy
//searching
//xml parser
//machine learning
//dns
//indexing
//networking

//perfect = full + complete

public class BinaryTree<E>{

    private class Node<E> implements Position<E>{
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
            return root;
        }
    }

    public Position<E> left(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            return node.left;
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    public Position<E> right(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            return node.right;
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    public Position<E> parent(Position<E> p){
        if(p instanceof Node<E>){
            Node<E> node = (Node<E>) p;
            if(node == root){
                return null;
            }
            else{
                return node.parent;
            }
        }
        else{
            throw new IllegalStateException("not valid position type");
        }
    }

    public Position<E> sibling(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(node == root){
            return null;
        }
        else{
            Node<E> parent = node.parent;
            if(parent.left == node){
                return parent.right;
            }
            if(parent.right == node){
                return parent.left;
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
            list.add(node.left);
        }
        if(node.right != null){
            list.add(node.right);
        }
        return list;
    }

    public int depth(Position<E> p){
        Node<E> node = (Node<E>) p;
        if(isRoot(p)){
            return 0;
        }
        else{
            return depth(node.parent) + 1;
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

    public Position<E> addRoot(E element){
        if(isEmpty()){
            Node<E> newRoot = new Node<E>(element,null,null,null);
            root = newRoot;
            size++;
            return newRoot;
        }
        else{
            throw new IllegalStateException("tree is not empty");
        }
    }

    public Position<E> addLeft(Position<E> p,E element){
        Node<E> node = (Node<E>) p;
        Node<E> newNode = new Node<E>(element,null,null,null);
        if(node.left == null){
            node.left = newNode;
            newNode.parent = node;
            size++;
            return newNode;
        }
        else{
            throw new IllegalStateException("p already has a left child");
        }
    }

    public Position<E> addRight(Position<E> p,E element){
        Node<E> node = (Node<E>) p;
        Node<E> newNode = new Node<E>(element,null,null,null);
        if(node.right == null){
            node.right = newNode;
            newNode.parent = node;
            size++;
            return newNode;
        }
        else{
            throw new IllegalStateException("p already has a right child");
        }
    }

    public E set(Position<E> p,E element){
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

    public E remove(Position<E> p){
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

    public void attach(Position<E> p,BinaryTree<E> t1,BinaryTree<E> t2){
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
}
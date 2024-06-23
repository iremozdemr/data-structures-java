import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTreeInterface<E>{

    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);

        if(parent == null){
            return null;
        }
        else if(p == left(parent)){
            return right(parent);
        }
        else{
            return left(parent);
        }
    }

    public int numChildren(Position<E> p){
        int result = 0;

        if(left(p) != null){
            result++;
        }

        if(right(p) != null){
            result++;
        }

        return result;
    }

    public Iterable<Position<E>> children(Position<E> p){
        ArrayList<Position<E>> list = new ArrayList<>();

        if(left(p) != null){
            list.add(left(p));
        }

        if(right(p) != null){
            list.add(right(p));
        }

        return list;
    }
}
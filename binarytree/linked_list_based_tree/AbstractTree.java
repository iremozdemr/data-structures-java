public abstract class AbstractTree<E> implements TreeInterface<E>{

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

    public boolean isRoot(Position<E> p){
        if(p == root()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
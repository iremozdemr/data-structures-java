//hierarchy
//searching
//xml parser
//machine learning
//dns
//indexing
//networking

//bir node'un çocukları varsa = internal
//bir node'un çocukları yoksa = external

//ancestor = parent
//descendant = child

//interface'lerde method body'si tanımlanamaz
//abstract class'larda method body'si tanımlanabilir

import java.util.Iterator;

public interface TreeInterface<E> extends Iterable<E>{

    Position<E> root();
    //tree boşsa null döner

    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    //p root ise null döner

    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    //tree eğer ordered tree ise children'ları sıralı olarak döner

    int numChildren(Position<E> p) throws IllegalArgumentException;

    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
//bu methodlara invalid position parametre olarak verilirse
//exception atar
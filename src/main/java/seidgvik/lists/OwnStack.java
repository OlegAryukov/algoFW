package seidgvik.lists;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class OwnStack<T> implements Iterable<T> {
    private OwnNode<T> first;
    private int N;

    private class OwnNode<T> {
        T data;
        OwnNode next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(T data){
        OwnNode old = first;
        first = new OwnNode<>();
        first.data = data;
        old.next = first;
        N++;
    }

    public T pop(){
        T data = first.data;
        first = first.next;
        N--;
        return data;
    }
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}

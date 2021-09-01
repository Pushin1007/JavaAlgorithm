package hw4;

import hw3.deque.Deque;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DequeLinkedListImpl<E>  implements Deque<E> {

    private final TwoSideLinkedList<E> data;

    public DequeLinkedListImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public E peekRight() {
        return data.getLast();
    }

    @Override
    public E peekLeft() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

}




//import java.util.Iterator;
//
//public class SOList<Type> implements Iterable<Type> {
//
//    private Type[] arrayList;
//    private int currentSize;
//
//    public SOList(Type[] newArray) {
//        this.arrayList = newArray;
//        this.currentSize = arrayList.length;
//    }
//
//    @Override
//    public Iterator<Type> iterator() {
//        Iterator<Type> it = new Iterator<Type>() {
//
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < currentSize && arrayList[currentIndex] != null;
//            }
//
//            @Override
//            public Type next() {
//                return arrayList[currentIndex++];
//            }
//
//            @Override
//            public void remove() {
//                throw new UnsupportedOperationException();
//            }
//        };
//        return it;
//    }
//}

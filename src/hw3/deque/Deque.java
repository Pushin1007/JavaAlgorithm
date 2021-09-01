package hw3.deque;

public interface Deque<E>  {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    E peekRight();

    E peekLeft();


    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}

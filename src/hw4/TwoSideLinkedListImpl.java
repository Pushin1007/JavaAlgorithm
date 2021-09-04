package hw4;


import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>, Iterable<E> {

    protected Node<E> lastElement;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if (size == 1) {
            lastElement = firstElement;
        }
    }


    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        Node<E> tempNonde = lastElement;
        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        lastElement.next = newNode;
        lastElement = newNode;
        lastElement.previous = tempNonde;
        size++;
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if (isEmpty()) {
            lastElement = null;
        }

        return removedValue;
    }

    @Override
    public E removeLast() { // для Deque нужен метод. создаем
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = lastElement;
        lastElement = removedNode.previous;

        lastElement.next = null;
        size--;

        if (isEmpty()) {
            firstElement = null;
        }
        return getValue(removedNode);

    }


    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new TwoSideLinkedListIterator();
    }


    private class TwoSideLinkedListIterator<E> implements Iterator<E> {

        private final TwoSideLinkedListImpl<E> data;
        private Node<E> current;
        private Node<E> previous;

        public TwoSideLinkedListIterator() {
            this.data = (TwoSideLinkedListImpl<E>) TwoSideLinkedListImpl.this;
            reset();
        }


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
//            if (!hasNext()) {
//                throw new NoSuchElementException();
//            }
            E nextValue = current.item;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null) {
                data.firstElement = current.next;
                reset();
            } else {
                previous.next = current.next;
                if (!hasNext()) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        public void reset() {
            current = data.firstElement;
            previous = null;
        }
    }
}

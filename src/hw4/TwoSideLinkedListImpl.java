package hw4;


import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

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

        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        lastElement.next = newNode;
        lastElement = newNode;
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
        } else {
//            lastElement.previous.next = null;//не могу обнулить сслылку последнего узла на удаляемый узел
        }
        Node<E> removedNode = lastElement;
        lastElement = removedNode.previous;

        removedNode.previous = null;
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

    public class TwoSideLinkedListIterator<E> implements Iterable<E> {

        TwoSideLinkedList<E> data;
        private int size;

        public TwoSideLinkedListIterator() {
            this.data = data;
            this.size = data.size();
        }


        @Override
        public Iterator<E> iterator() {
            Iterator<E> it = new Iterator<E>() {

                Node<E> current = data.firstElement;

                @Override
                public boolean hasNext() {
                    return current.next!= null;
                }

                @Override
                public E next() {
                    return getValue(current.next);
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
            return it;
        }
    }
}

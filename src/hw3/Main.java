package hw3;

import hw3.deque.DequeImpl;

public class Main {
    public static void main(String[] args) {
        testDeque();
    }


    private static void testDeque() {

        DequeImpl<Integer> deque = new DequeImpl<>(5);



        System.out.println("add element: " + deque.insertLeft(34));
        deque.display();
        System.out.println("add element: " + deque.insertRight(12));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(20));
        deque.display();
        System.out.println("add element: " + deque.insertRight(14));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(16));
        deque.display();
        System.out.println("add element: " + deque.insertRight(17));

        deque.display();
        System.out.println("remove: " + deque.removeRight());
        deque.display();
        System.out.println("remove: " + deque.removeLeft());
        deque.display();

    }


}


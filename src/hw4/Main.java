package hw4;

public class Main {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {

        DequeLinkedListImpl dequeList = new DequeLinkedListImpl<Integer>();

        System.out.println("add element: " +  dequeList.insertLeft(1));
        System.out.println("add element: " +  dequeList.insertLeft(2));
        System.out.println("add element: " + dequeList.insertRight(11));
        System.out.println("add element: " + dequeList.insertRight(11));
        System.out.println("add element: " + dequeList.insertLeft(1));
        System.out.println("add element: " +  dequeList.insertRight(13));



        dequeList.display();

       System.out.println("remove: " + dequeList.removeLeft());
        dequeList.display();

        System.out.println("remove: " + dequeList.removeRight());
        dequeList.display();


        //ДОЛЖНО РАБОТАТЬ! Iterable - LinkedListIterator impl Iterator

/*        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }*/
    }

}

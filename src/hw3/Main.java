package hw3;

import hw3.deque.DequeImpl;

public class Main {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        System.out.println(findMissInt1(arr));


        int[] array = new int[]{1, 2, 4};
        int missInt = findMissInt2(array, 0, array.length - 1);
        System.out.println(missInt);


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

    public static int findMissInt1(int[] intArray) { //простая реализация O(n)
        int summ = 0;
        for (int i = 0; i < intArray.length; i++) {
            summ = summ + intArray[i];
        }
        int n = intArray.length + 1; //количество чисел в массиве + одно пропущенное
        int total = ((n + 1) * n / 2); // Сумма натуральных чисел от 1 до  n
        return total - summ;
    }

    public static int findMissInt2(int[] intArray, int start, int fin) { // реализация использует бинарный поиск сложность O(logn)

        if (fin == start) { // если пустой массив
            return 1;
        }
        if (fin == start + 1) { // Если число пропущенно между двумя числами, то оно равно следующему  после intArray[start]
            return intArray[start] + 1;
        }

        int pivot = start + (fin - start) / 2; //находим некий серединный индекс в части массива где утерян элемент

        if (intArray[pivot] == intArray[start] + (intArray[fin] - intArray[start]) / 2 - (fin - start) % 2) // Проверяем значение серединного элемента.  Если все цифры на месте то мы легко можем узнать значение по его индексу
            return findMissInt2(intArray, pivot, fin); //Если оно совпадает с расчетным то значение пропущенно в правой половине, которую потом снова делим пополам
        else
            return findMissInt2(intArray, start, pivot);  //Если условие не выполняется ищем пропущенный элемент в левой половине, которую потом снова делим пополам
    }

}


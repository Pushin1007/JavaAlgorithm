package hw3;

//1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1).
// Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
//Примеры:
//[1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
//[1, 2, 4, 5, 6] => 3
//[] => 1
//
//2. Создать класс для реализации Deque

public class Main {
    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        System.out.println(findMissInt1(arr));


        int[] array = new int[]{1, 2, 4};
        int missInt = findMissInt2(array, 0, array.length - 1);
        System.out.println(missInt);


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
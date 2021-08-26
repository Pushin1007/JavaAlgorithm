package hw2;

public class SelectionSort { // Класс сортировки выбором
    public static void sort(Notebook[] arr) {

        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < arr.length; j++) {


                if (arr[j].compareTo(arr[min]) < 0) { //Вариант в классе ноутбука реализовал интерфейс comparable, а в методе сортировки SelectionSort  использовал метод compare.
                    min = j;
                }

            }
            if (i == min) {
                continue;
            }

            Notebook temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}


package hw2;


public class BubbleSortIndex {
    public static void sort(Notebook[] arr) { //Метод сортировки пузырьком по некоему индексу. Долго!!!
        boolean isChange;
        int limit = arr.length;
        do {
            isChange = false;
            limit--;
            for (int i = 0; i < limit; i++) {
                if (ArrayNotebook.index(arr[i]) > ArrayNotebook.index(arr[i+1])) { //сравнивание индексов
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                }
            }
        } while (isChange);
    }
}


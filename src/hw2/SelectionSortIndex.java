package hw2;

public class SelectionSortIndex {
    public static void sort(Notebook[] arr) { //Метод сортировки пузырьком по некоему индексу. Долго!!!

        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (ArrayNotebook.index(arr[j]) < ArrayNotebook.index(arr[min])) {
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


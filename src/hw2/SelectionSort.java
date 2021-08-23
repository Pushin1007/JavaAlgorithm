package hw2;

public class SelectionSort { // Класс сортировки выбором
    public static void sort(Notebook[] arr) {

        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getCost() < arr[min].getCost()) { //Вариант логики сравнения внутри цикла
                    min = j;
                }
                if (arr[j].getCost() == arr[min].getCost()) {
                    if (arr[j].getMemory() < arr[min].getMemory()) {
                        min = j;
                    }
                    if (arr[j].getMemory() == arr[min].getMemory()) {
                        if (ArrayNotebook.brandAwesomeness(arr[j].getBrand()) < ArrayNotebook.brandAwesomeness(arr[min].getBrand())) {
                            min = j;
                        }
                    }
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


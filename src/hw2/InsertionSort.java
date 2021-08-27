package hw2;


public class InsertionSort {
    public static void sort(Notebook[] arr) { //Метод сортировки вставкой
        for (int i = 1; i < arr.length; i++) {
            Notebook value = arr[i];
            int j = i - 1;
            while (j >= 0 && findPlase(arr[j], value)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;

        }
    }

    public static boolean findPlase(Notebook a, Notebook b) { //Вариант вынесенного отдельно метода сравнения ноутбуков
        if (a.getCost() > b.getCost()) {
            return true;
        }
        if (a.getCost() == b.getCost()) {
            if (a.getMemory() > b.getMemory()) {
                return true;
            }
            if (a.getMemory() == b.getMemory()) {
                if (ArrayNotebook.brandAwesomeness(a.getBrand()) > ArrayNotebook.brandAwesomeness(b.getBrand())) {
                    return true;
                }
            }
        }
        return false;
    }
}



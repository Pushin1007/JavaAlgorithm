package hw2;



public class BubbleSort {
    public static void sort(Notebook[] arr) { //метод сортировки пузырьком
        boolean isChange;
        int limit = arr.length;
        do {
            isChange = false;
            limit--;
            for (int i = 0; i < limit; i++) { // Вариант логики не вынесенной в отдельный метод
                if (arr[i].getCost() > arr[i + 1].getCost()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isChange = true;
                }
                if (arr[i].getCost() == arr[i + 1].getCost()) {
                    if (arr[i].getMemory() > arr[i + 1].getMemory()) {
                        Notebook temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        isChange = true;
                    }
                    if (arr[i].getMemory() == arr[i + 1].getMemory()) {
                        if (ArrayNotebook.brandAwesomeness(arr[i].getBrand()) > ArrayNotebook.brandAwesomeness(arr[i + 1].getBrand())) {
                            Notebook temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                            isChange = true;
                        }
                    }
                }
            }
        } while (isChange);
    }
}



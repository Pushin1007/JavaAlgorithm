package hw2;

import java.util.Random;

public class ArrayNotebook { // Класс для создания массивов ноутбуков

    private static final Random random = new Random();

    final static int MINCOST = 500; // Минимальная цена ноутбука
    final static int MAXCOST = 1000; // Максимальная цена ноутбука
    final static int STEPCOST = 100; // Шаг изменения цены
    final static int MINMEMORY = 4; // Минимальный объем памяти
    final static int MAXMEMORY = 12; // Максимальный объем памяти
    final static int STEPMEMORY = 4; //шаг изменения объема памяти
    // Бренды расположены в порядке  приоритета. Lenuvo > Asos > MacNote > Eser > Xamiou. Самый НЕ приоритетный Xamiou
    final static String[] BRAND = {"Xamiou", "Eser", "MacNote", "Asos", "Lenuvo"};


    public static Notebook[] getArray(int countNotebook) {// метод создания массива ноутбуков
        int cost;
        int memory;
        String brand;

        Notebook[] arr = new Notebook[countNotebook];

        for (int i = 0; i < countNotebook; i++) {
            cost = (MINCOST + random.nextInt((MAXCOST - MINCOST) / STEPCOST + 1) * STEPCOST);
            memory = (MINMEMORY + random.nextInt((MAXMEMORY - MINMEMORY) / STEPMEMORY + 1) * STEPMEMORY);
            brand = BRAND[random.nextInt(5)];
            arr[i] = new Notebook(cost, memory, brand);
        }
        return arr;
    }


    public static void shuffleArray(Notebook[] arr) {// метод перемешивания массива
        int n = arr.length;
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(arr, i, change);
        }
    }

    private static void swap(Notebook[] a, int i, int change) {// метод смены мест элементов массива
        Notebook temp = a[i];
        a[i] = a[change];
        a[change] = temp;
    }

    public static void printArray(Notebook[] arr) {// метод печати массива
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i].printParam();
        }
    }

    public static int brandAwesomeness(String brand) { //Метод определени "крутости" бренда
        for (int i = 1; i < BRAND.length; i++) {
            if (brand.equals(BRAND[i])) {
                return i; //Возвращаем порядковый номер бренда. Чем больше номер - тем "лучше" ноутбук
            }
        }
        return 0;
    }

    public static int index(Notebook notebook) { // Попытка создать некий индекс ноутбука, который определит его "крутость"
        int index = 0;
        int countCosts = (MAXCOST - MINCOST) / STEPCOST + 1;
        int countMemorys = (MAXMEMORY - MINMEMORY) / STEPMEMORY + 1;
        int countBrands = BRAND.length;

        for (int i = 0; i < countCosts; i++) {
            for (int j = 0; j < countMemorys; j++) {
                for (int k = 0; k < countBrands; k++) {
                    index = notebook.getCost() + notebook.getMemory() * 10 + ArrayNotebook.brandAwesomeness(notebook.getBrand());// разделяем по значениям параметры ноута
                }
            }
        }
        return index;
    }
}





package hw2;

public class Main {

//1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 5000 штук.
//    Условия для сортировки:
//          1) по цене. От 500 до 1000 долларов с шагом в 100
//    если цена равная, то
//          2) по кол-ву оперативной памяти (от 4 до 12 с шагом 4)
//    если памяти тоже равное количество, то
//          3) по производителю:
//    Lenuvo > Asos > MacNote > Eser > Xamiou
//    Добиваться максимально оптимальной сложности О-большая
//
//2. Впитать материал урока, ознакомиться с доп. материалами

    private static Long time;

    public static void main(String[] args) {
        startTime();
        Notebook[] arrayNotebook = ArrayNotebook.getArray(5000); //создаем массив ноутбуков
        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Печать массива. ");
        endTime();

        startTime();
        BubbleSort.sort(arrayNotebook);
//        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Cортировка Пузырьком. ");
        endTime();

        ArrayNotebook.shuffleArray(arrayNotebook);
        startTime();
        SelectionSort.sort(arrayNotebook);
        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Cортировка Выбором. ");
        endTime();


// !!! Этот метод сортировки самый быстрый даже при 10000 ноубруков. Его и оставляем!!!
        ArrayNotebook.shuffleArray(arrayNotebook);
        startTime();
        InsertionSort.sort(arrayNotebook);
//        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Cортировка Вставкой. ");
        endTime();


        ArrayNotebook.shuffleArray(arrayNotebook); // Вариант сортировки индексированного массива. Слишком доло
        startTime();
        BubbleSortIndex.sort(arrayNotebook);
//        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Cортировка Пузырьком Индексированного Массива. ");
        endTime();


        ArrayNotebook.shuffleArray(arrayNotebook);  // Вариант сортировки индексированного массива. Слишком доло
        startTime();
        SelectionSortIndex.sort(arrayNotebook);
//        ArrayNotebook.printArray(arrayNotebook);
        System.out.print("Cортировка Выбором Индексированного Массива. ");
        endTime();

    }

    public static void startTime() {
        time = System.currentTimeMillis();
    } // Засекаем время начало операции

    public static void endTime() { // Вычисляем время выполнения операции
        time = System.currentTimeMillis() - time;
        System.out.println("Затраченное время: " + time + "мс");
    }

}

package hw2;

public class Notebook implements Comparable<Notebook> { //класс ноутбука
    private int cost;
    private int memory;
    private String brand;

    public Notebook(int cost, int memory, String brand) {
        this.cost = cost;
        this.memory = memory;
        this.brand = brand;
    }

    public void printParam() { //метод печати ноутбуков
        System.out.printf("Cost: %d $, Memory: %d Gb, Brand: %s \n", cost, memory, brand);
    }

    public int getCost() {
        return cost;
    }

    public int getMemory() {
        return memory;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public int compareTo(Notebook notebook) { //в классе ноутбука реализовал интерфейс comparable, а в методе сортировки SelectionSort  использовал метод compare.
        int result;
        if (this.cost >  notebook.cost) {
            return 1;
        }
        if (this.cost == notebook.cost) {
            if (this.memory > notebook.memory) {
                return 1;
            }
            if (this.memory == notebook.memory) {
                if (ArrayNotebook.brandAwesomeness(this.getBrand()) > ArrayNotebook.brandAwesomeness(notebook.getBrand())) {
                    return 1;
                }
            }
        }
        return -1;
    }

}


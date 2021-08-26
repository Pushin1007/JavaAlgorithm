package hw2;

public class Notebook implements Comparable{ //класс ноутбука
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
    public int compareTo(Object o) { //в классе ноутбука реализовал интерфейс comparable, а в методе сортировки SelectionSort  использовал метод compare.
        int result;
        if (this.cost > ((Notebook)o).cost) {
            return 1;
        }
        if (this.cost == ((Notebook)o).cost) {
            if (this.memory > ((Notebook)o).memory) {
                return 1;
            }
            if (this.memory == ((Notebook)o).memory) {
                if (ArrayNotebook.brandAwesomeness(this.getBrand()) > ArrayNotebook.brandAwesomeness(((Notebook)o).getBrand())) {
                    return 1;
                }
            }
        }
        return -1;
    }

}


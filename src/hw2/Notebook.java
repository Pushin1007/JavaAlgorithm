package hw2;

public class Notebook { //класс ноутбука
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

}

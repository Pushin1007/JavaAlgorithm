package hw5;


public class Thing {
    private  String name; //название вещи
    private  int weight; //вес
    private  int price; //стоимость

    public Thing(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }


}

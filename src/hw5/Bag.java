package hw5;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private List<Thing> bestList= new ArrayList<>();
    private int bestPrice;
    private final int W = 10;


    public static void main(String[] args) {

        List<Thing> things = new ArrayList<>();


        things.add(new Thing("saw", 7, 50));
        things.add(new Thing("phone", 1, 25));
        things.add(new Thing("book", 2, 15));
        things.add(new Thing("book", 2, 15));

        display(new Bag().findBestThings(things));
    }


    private Integer calcWeigth(List<Thing> things) { // метод высислениявеса набора
        Integer sumW = 0;
        for (Thing thing : things) {
            sumW = sumW + thing.getWeight();
        }
        return sumW;
    }

    private Integer calcPrice(List<Thing> things) { //метод вычисления стоимости набора
        Integer sumC = 0;
        for (Thing thing : things) {
            sumC = sumC + thing.getPrice();
        }
        return sumC;
    }

    private void checkSet(List<Thing> things) { // метод сравнения наборов
        if (bestList == null) {
            if (calcWeigth(things) <= W) {
                bestList = things;
                bestPrice = calcPrice(things);
            }
        } else {
            if (calcWeigth(things) <= W && calcPrice(things) > bestPrice) {
                bestList = things;
                bestPrice = calcPrice(things);
            }
        }
    }


    private List<Thing> findBestThings(List<Thing> things) {
        bestList.clear();
        findThings(things);
        return bestList;
    }

    public void findThings(List<Thing> things) { //создание всех наборов перестановок значений
        if (things.size() > 0) {
            checkSet(things);
        }
        for (int i = 0; i < things.size(); i++) {

            List<Thing> newList = things;

            newList.remove(i);

            findThings(newList);
        }

    }

    public static void display(List<Thing> things) {
        for (Thing thing : things) {
            System.out.println(thing.getName());
        }
    }
}




package hw7;

public class Main {

    public static void main(String[] args) {

        GraphImpl cities = new GraphImpl(10);

        cities.addVertex("Москва");
        cities.addVertex("Тула");
        cities.addVertex("Липецк");
        cities.addVertex("Рязань");
        cities.addVertex("Тамбов");
        cities.addVertex("Саратов");
        cities.addVertex("Воронеж");
        cities.addVertex("Калуга");
        cities.addVertex("Орел");
        cities.addVertex("Курск");

        cities.addEdge("Москва", "Тула", 300);
        cities.addEdge("Москва", "Рязань", 500);
        cities.addEdge("Москва", "Калуга", 700);
        cities.addEdge("Тула", "Липецк", 300);
        cities.addEdge("Липецк", "Воронеж", 300);
        cities.addEdge("Рязань", "Тамбов", 300);
        cities.addEdge("Тамбов", "Саратов", 50);
        cities.addEdge("Саратов", "Воронеж", 80);
        cities.addEdge("Калуга", "Орел", 100);
        cities.addEdge("Орел", "Курск", 50);
        cities.addEdge("Курск", "Воронеж", 70);

//        System.out.println("Всего городов " + cities.getSize());
//        cities.display();
//        cities.dfs("Москва");
        cities.findShortPathViaBfs("Москва", "Воронеж");


    }
}

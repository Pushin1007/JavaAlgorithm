package hw7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<City> cityList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxCityCount) {
        this.cityList = new ArrayList<>(maxCityCount);
        this.adjMatrix = new int[maxCityCount][maxCityCount];
    }

    @Override
    public void addVertex(String label) {
        cityList.add(new City(label));
    }

    @Override
    public boolean addEdge(String startLabel, String endLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        if (startLabel.equals(endLabel)) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = weight;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < cityList.size(); i++) {
            if (cityList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return cityList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.println(cityList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    System.out.println(" -> " + cityList.get(j) + " " + adjMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }

        Stack<City> stack = new Stack<>();
        City city = cityList.get(startIndex);

        visitCity(stack, city);
        while (!stack.isEmpty()) {
            city = getNearUnvisitedCity(stack.peek());
            if (city != null) {
                visitCity(stack, city);
            } else {
                stack.pop();
            }
        }
    }


    private void visitCity(Stack<City> stack, City city) {
//        System.out.println(city.getLabel());
        stack.push(city);
//        city.setVisited(true);
    }

    private void visitCity(Queue<City> stack, City city) {
        System.out.println(city.getLabel());
        stack.add(city);
        city.setVisited(true);
    }

    private City getNearUnvisitedCity(City city) {
        int currentIndex = cityList.indexOf(city);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !cityList.get(i).isVisited()) {
                return cityList.get(i);
            }
        }
        return null;
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверный индекс: " + startLabel);
        }
        Queue<City> stack = new LinkedList<>();
        City city = cityList.get(startIndex);

        visitCity(stack, city);
        while (!stack.isEmpty()) {
            city = getNearUnvisitedCity(stack.peek());
            if (city != null) {
                visitCity(stack, city);

            } else {
                stack.remove();
            }
        }
    }

    @Override
    public void findShortPathViaBfs(String startLabel, String finishLabel) {
        int shortestRoad = 0;
        int road = 0;
        List<String> shortCityList = new ArrayList<>();
        List<String> currentCityList = new ArrayList<>();

        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Города нет в списке: " + startLabel);
        }

        Stack<City> stack = new Stack<>(); //Делаем новый стек
        City city;

        do {
            city = cityList.get(startIndex);// берем стартовый город из списка городов
            currentCityList.add(startLabel); //добавляем его в список текущих городов
            stack.push(city); //добавляем его в стек
            city.setVisited(true); // ставим его посещенным

            do {
                city = getNearUnvisitedCity(stack.peek());
                if (city != null) {
                    road = road + adjMatrix[indexOf(stack.peek().getLabel())][indexOf(city.getLabel())];
                    currentCityList.add(city.getLabel());
                    stack.push(city);
                    city.setVisited(true);
                }
            } while (!city.getLabel().equals(finishLabel));// проходим все города пока не упремся в финальный город
            city.setVisited(false); // говорим конечной точке что мы к ней еще вернемся другим путем

            if (shortestRoad == 0 || shortestRoad != 0 && shortestRoad > road) { // если это первый проход, или нашли путь меньше чем предыдущий, то сохраняем значение и список городов
                shortestRoad = road;
                shortCityList.clear();
                shortCityList.addAll(currentCityList);
            }
            road = 0;
            currentCityList.clear();
            stack.clear();
        } while (getNearUnvisitedCity(cityList.get(startIndex)) != null);

        System.out.print("Кратчайший путь: " + shortestRoad + " ");
        System.out.println(shortCityList);
    }


    //                    // Рабочий вариант, но костыльный. Решил не убирать
    //    @Override
//    public void findShortPathViaBfs(String startLabel, String finishLabel) {
//        int startIndex = indexOf(startLabel);
//        int shortestRoad = 0;
//        int road = 0;
//        List<String> currentCityList = new ArrayList<>();
//        List<String> shortCityList = new ArrayList<>();
//
//
//        if (startIndex == -1) {
//            throw new IllegalArgumentException("Города нет в списке: " + startLabel);
//        }
//
//        Stack<City> stack = new Stack<>();
//        City city = cityList.get(startIndex);
//
//        visitCity(stack, city);
//
//        while (!stack.isEmpty()) {
//            city = getNearUnvisitedCity(stack.peek());
//
//            if (city != null) {
//                road = road + adjMatrix[indexOf(stack.peek().getLabel())][indexOf(city.getLabel())];
//                currentCityList.add(city.getLabel());
//
//                visitCity(stack, city);
//                city.setVisited(true);
//
//                if (city.getLabel().equals(finishLabel)) {
//                    if (shortestRoad == 0 || shortestRoad != 0 && shortestRoad > road) {
//                        shortestRoad = road;
//                        shortCityList.clear();
//                        shortCityList.addAll(currentCityList);
//                    }
//                    // придумал откатываться на 2 шага назад, для того чтобы  в конечной точка не зависала,
//                    // и чтобы в нее можно было попасть второй раз по другому пути.
//                    // Программа работает, но это костыли
//                    stack.pop();
//                    stack.pop();
//                    city.setVisited(false);
//                    road = 0;
//                    currentCityList.clear();
//                }
//            } else {
//                stack.pop();
//
//            }
//        }
//        System.out.print("Кратчайший путь: " + shortestRoad + " ");
//        shortCityList.add(0, startLabel);
//        System.out.println(shortCityList);
//
//
//    }
}


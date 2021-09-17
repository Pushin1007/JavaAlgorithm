package hw7;


import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int weight);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS // Поиск в Глубину
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS // Поиск в Ширину
     */
    void bfs(String startLabel);

    void findShortPathViaBfs(String startLabel, String finishLabel); // Поиск кратчайшего пути

}


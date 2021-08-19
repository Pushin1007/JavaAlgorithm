package hw1;

import java.util.ArrayList;
import java.util.List;

public class аа {



    //с)Ответ: Сложность алгоритма  O(n^2), количество итераций 10000*5000=50000000
    public static void main(String[] args) {
        int n = 10;  // O(1)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = 0; j < n; j++) { // O(n/2)
                arrayList.add(i * j);
                n--;
            }
        }
    }


}

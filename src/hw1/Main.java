package hw1;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

//1. Прочитать в книге "Грокаем алгоритмы" или в предложенных материалах про алгоритмы и О-большое.

//2. Определить сложность следующих алгоритмов:

//-. Поиск элемента массива с известным индексом // Ответ: O(1)
//-. Дублирование одномерного массива через foreach // Ответ: O(n)=(O(n)+ O(n))
//-. Удаление элемента массива с известным индексом без сдвига // Ответ: O(1)+ O(1)
//-. Удаление элемента массива с неизвестным индексом без сдвига // Ответ: O(n) = (O(n)+ O(1))
//-. Удаление элемента массива с неизвестным индексом со сдвига // Ответ: O(n)=(O(n)+ O(1)+ O(n))

    //3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?

    //a) Ответ: Сложность алгоритма  O(nlogn), количество итераций 10000*4=40000
    public void example() {
        int n = 10000; // O(1)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = 1; j < n; j *= 2) { // O(logn)
                arrayList.add(i * j);
            }
        }
    }

    //b) Ответ: Сложность алгоритма  O(n^2), количество итераций 5000*10000=50000000
    public void example2() {
        int n = 10000; // O(1)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) { // O(n/2)
            for (int j = i; j < n; j++) { // O(n)
                arrayList.add(i * j);
            }
        }
    }

    //с)Ответ: Сложность алгоритма  O(n), количество итераций 10000=5000+2500+1250+625+313+156+78+39+19+9+4+2+1
    public void example3() {
        int n = 10000;  // O(1)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
            }
        }
    }

    //d) Ответ: Сложность алгоритма O(n) , количество итераций 10000 т.к. рекурсивный метод вызывается 10000раз


//    factorial(BigInteger.valueOf(10000));
//
//    public static BigInteger factorial (BigInteger n){
//        if (n.equals(BigInteger.ONE)) {
//            return n;
//        }
//        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
//    }


    //e)Ответ: Сложность алгоритма O(2^n) , количество итераций (Наверно, могу ошибаться...) 1125899906842624
//    fib(BigInteger.valueOf(50));
//
//    public static BigInteger fib(BigInteger n) {
//        if (n.equals(BigInteger.ONE)) {
//            return BigInteger.ZERO;
//        }
//        if (n.equals(BigInteger.TWO)) {
//            return BigInteger.ONE;
//        }
//        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
//    }

}

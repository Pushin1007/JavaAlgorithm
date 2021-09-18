package hw8;

public class Main {

    public static void main(String[] args) {

        HashTable<Integer, Integer> hashTable = new HashTableImpl<>(4);

        hashTable.put(35, 150);
        hashTable.put(30, 200);
        hashTable.put(25, 175);
        hashTable.put(45, 100);
        hashTable.put(50, 50);
        hashTable.put(1, 30);
        hashTable.put(15, 15);
        hashTable.put(51, 51);
        hashTable.put(52, 52);
        hashTable.put(53, 53);
        hashTable.put(54, 54);
         System.out.println(hashTable.remove(15));

        System.out.println("Size is " + hashTable.size());

        hashTable.display();
    }
}

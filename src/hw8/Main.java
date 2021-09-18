package hw8;

public class Main {

    public static void main(String[] args) {

        HashTable<Integer, Integer> hashTable = new HashTableImpl<>(6);

        hashTable.put(35, 150);
        hashTable.put(30, 200);
        hashTable.put(25, 175);
        hashTable.put(45, 100);
        hashTable.put(50, 50);
        hashTable.put(1, 30);
        hashTable.put(15, 5);

        System.out.println("Size is " + hashTable.size());

        hashTable.display();
    }
}

package hw8;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> {

        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Item<K, V> getNext() {
            return next;
        }

        public void setNext(Item<K, V> next) {
            this.next = next;
        }

        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }


    private final Item<K, V>[] data;

    private final Item<K, V> emptyItem;

    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new Item<>(key, value);
        } else {
            Item<K, V> item = data[index];
            while (item.getNext() != null && item.getKey() != key) {
                item = item.getNext();
            }
            if (item.getKey() == key) {
                item.setValue(value);
            } else {
                item.setNext(new Item<>(key, value));
            }
        }
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        if (data[index] == null)
            return null;
        else {
            Item<K, V> item = data[index];
            while (item != null && item.getKey() != key) {
                item = item.getNext();
            }
            return item.getValue();
        }
    }


    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] != null) {
            Item<K, V> prevItem = null;
            Item<K, V> item = data[index];

            while (item.getNext() != null && item.getKey() != key) {
                prevItem = item;
                item = item.getNext();
            }
            if (item.getKey() == key) {
                if (prevItem == null) {
                    data[index] = item.getNext();
                } else {
                    prevItem.setNext(item.getNext());
                    size--;
                    return item.getValue();
                }
            }
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("---------------");

        for (int i = 0; i < data.length; i++) {
            System.out.print(i + " = ");
                  if (data[i] != null) {
                Item<K, V> item = data[i];

                do {
                    System.out.print( "["+ item.getValue() + "] ");
                    item = item.getNext();
                } while (item != null);
            }
            System.out.println();

        }
        System.out.println("---------------");
    }

}



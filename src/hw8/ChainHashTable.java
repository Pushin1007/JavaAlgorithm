package hw8;


public class ChainHashTable implements HashTable {
    private static final int START_CAPACITY = 16;
    private Chain[] data;
    private int capacity;

    public ChainHashTable() {
        capacity = START_CAPACITY;
        data = new Chain[capacity];
        for (int i = 0; i < capacity; ++i) {
            data[i] = null;
        }
    }

    public ChainHashTable(int capacity) {
        data = new Chain[capacity];
        this.capacity = capacity;
        for (int i = 0; i < this.capacity; i++) {
            data[i] = null;
        }
    }

    @Override
    public void add(int key, int value) {
        final int index = (key % capacity);
        if (data[index] == null) {
            data[index] = new Chain(key, value);
        } else {
            Chain entry = data[index];
            while (entry.getNext() != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                entry.setValue(value);
            } else {
                entry.setNext(new Chain(key, value));
            }
        }
    }

    @Override
    public void delete(int key) {
        final int index = (key % capacity);
        if (data[index] != null) {
            Chain prevEntry = null;
            Chain entry = data[index];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null) {
                    data[index] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }

    @Override
    public Integer search(int key) {
        final int index = (key % capacity);
        if (data[index] == null)
            return null;
        else {
            Chain entry = data[index];
            while (entry != null && entry.getKey() != key) {
                entry = entry.getNext();
            }
            if (entry == null) {
                return null;
            } else {
                return entry.getValue();
            }
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < capacity; ++i) {
            final Chain entry = data[i];
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer min() {
        if (isEmpty()) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < capacity; ++i) {
            Chain entry = data[i];
            if (entry != null) {
                do {
                    if (entry.getKey() <= min) {
                        min = entry.getKey();
                        result = entry.getValue();
                    }
                    entry = entry.getNext();
                } while (entry != null);
            }
        }
        return result;
    }

    @Override
    public Integer max() {
        if (isEmpty()) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < capacity; ++i) {
            Chain entry = data[i];
            if (entry != null) {
                do {
                    if (entry.getKey() >= max) {
                        max = entry.getKey();
                        result = entry.getValue();
                    }
                    entry = entry.getNext();
                } while (entry != null);
            }
        }
        return result;
    }

    @Override
    public String print() {
        final StringBuilder description = new StringBuilder("Hash table: [ ");
        for (int i = 0; i < capacity; i++) {
            description.append("{  ");
            if (data[i] != null) {
                Chain entry = data[i];
                do {
                    description.append(String.format("%d  ", entry.getValue()));
                    entry = entry.getNext();
                } while (entry != null);
            }
            description.append("} ");
        }
        description.append(']');
        return description.toString();
    }

}

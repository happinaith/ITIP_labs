import java.util.LinkedList;

class HashTable<K, V> {
    private static class HashNode<K, V> {
        K key;
        V value;

        
        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode<K, V>>[] table; 
    private int capacity; 
    private int size; 


    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity]; 
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>(); 
        }
        this.size = 0; 
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key); 
        LinkedList<HashNode<K, V>> bucket = table[index]; 

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; 
                return; 
            }
        }

        
        bucket.add(new HashNode<>(key, value));
        size++; 
    }

    public V get(K key) {
        int index = hash(key); 
        LinkedList<HashNode<K, V>> bucket = table[index]; 

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value; 
            }
        }

        return null; 
    }

    public void remove(K key) {
        int index = hash(key); 
        LinkedList<HashNode<K, V>> bucket = table[index]; 

        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); 
                size--; 
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<Integer, Order> hashTable = new HashTable<>(10);
        
        Order order1 = new Order(50, "Chicken", 1120);
        Order order2 = new Order(25, "Fries", 1100);
        hashTable.put(1, order1);
        hashTable.put(2,order2);
        hashTable.put(2, order1);

        System.out.println(hashTable.size());
    }
}

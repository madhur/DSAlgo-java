package hashmapchaining;

public class App {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put(1, 10);
        System.out.println();
        hashTable.put(2, 100);
        System.out.println();
        hashTable.put(3, 1000);
        System.out.println();
        hashTable.put(4, 10000);

        hashTable.put(5, 10);
        hashTable.put(6, 100);
        hashTable.put(7, 1000);
        hashTable.put(8, 10000);
        hashTable.put(9, 10);
        hashTable.put(10, 100);
        hashTable.put(11, 1000);

        System.out.println(hashTable.get(4));
    }
}

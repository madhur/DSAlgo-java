package generichashtable;

public class App {

    public static void main(String[] args) {

        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("a", 1);
        System.out.println(hashTable.size());

        hashTable.put("b", 2);
        System.out.println(hashTable.size());

        hashTable.put("c", 3);
        System.out.println(hashTable.size());

        hashTable.put("d", 4);
        System.out.println(hashTable.size());

        hashTable.put("e", 5);
        System.out.println(hashTable.size());

        hashTable.put("f", 6);
        System.out.println(hashTable.size());

        hashTable.put("g", 7);
        System.out.println(hashTable.size());

        hashTable.put("h", 8);
        System.out.println(hashTable.size());

        hashTable.put("i", 9);
        System.out.println(hashTable.size());

        hashTable.put("j", 10);
        System.out.println(hashTable.size());

        hashTable.put("k", 11);
        System.out.println(hashTable.size());


        hashTable.remove("a");
        hashTable.remove("b");
        hashTable.remove("c");
        hashTable.remove("d");
        hashTable.remove("e");
        hashTable.remove("f");



    }
}

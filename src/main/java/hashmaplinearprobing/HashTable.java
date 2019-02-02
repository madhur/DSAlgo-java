package hashmaplinearprobing;

public class HashTable {

    private HashItem[] hashTable;

    public HashTable() {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public int get(int key) {

        int generatedIndex = hash(key);

        while (hashTable[generatedIndex] != null && hashTable[generatedIndex].getKey() != key) {
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Hopping to the next index: " + generatedIndex);
        }

        if (hashTable[generatedIndex] == null) {
            return -1;
        } else {
            return hashTable[generatedIndex].getValue();
        }
    }

    public void put(int key, int value) {

        int generatedIndex = hash(key);
        System.out.println("put() method called with value: " + value + " - generatedIndex: " + generatedIndex);

        while (hashTable[generatedIndex] != null ) {
            generatedIndex = (generatedIndex + 1) % Constants.TABLE_SIZE;
            System.out.println("Collision -> nextIndex: " + generatedIndex);
        }

        System.out.println("Finally generated with generatedIndex: " + generatedIndex);
        hashTable[generatedIndex] = new HashItem(key, value);
    }

    private int hash(int key) {
        //return key % Constants.TABLE_SIZE;
        return 0;
    }
}

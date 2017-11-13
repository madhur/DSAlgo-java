package Trie;

public class App {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("joe");
        trie.insert("joel");
        trie.insert("adamovich");
        trie.insert("helloworld");

        System.out.println(trie.search("joel"));
        System.out.println(trie.search("damovic"));


    }
}

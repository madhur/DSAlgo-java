package Trie;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("joe", 1);
        trie.insert("joel", 2);
        trie.insert("adamovich", 3);
        trie.insert("helloworld", 4);

        System.out.println(trie.search("joel"));
        System.out.println(trie.search("damovic"));

        System.out.println(trie.searchAsMap("helloworld"));

        List<String> list = trie.allWordsWithPrefix("adr");
        System.out.println(list);

    }
}

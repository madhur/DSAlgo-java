package unionfind;

import java.util.Arrays;

public class QuickUnionWithPathCompression {
    int []arr;

    public QuickUnionWithPathCompression(int N) {
        arr = new int[N];
        for(int i=0;i<N;++i) {
            arr[i] = i;
        }
    }

    private int root(int p) {
        int i = p;
        while (arr[i]!=i) {
            i = arr[i];
        }

        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        arr[i] = j;
    }

    public void print() {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    public static void main(String[] args) {
        QuickUnionWithPathCompression uf = new QuickUnionWithPathCompression(10);
        uf.union(0,5);
        uf.union(5,6);
        uf.union(1,2);
        uf.union(2,7);
        uf.union(8,3);
        uf.union(3,4);
        uf.union(4,9);

        uf.print();

    }
}


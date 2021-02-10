package unionfind;

import java.util.Arrays;

/**
 * Quick find approach with quadratic running time
 */
public class UF {

    int []arr;

    public UF(int n) {
        arr = new int[n];
        for(int i=0;i<n;++i) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {
        int s = arr[p];
        int d = arr[q];

        for(int i=0;i<arr.length;++i) {
            if(arr[i]==d) {
                arr[i] = s;
            }
        }

    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }

    public void print() {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        UF uf = new UF(10);
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

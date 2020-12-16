package AlgorithmFoundation.GreedyAL;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrimAL {
    final static int infi = Integer.MAX_VALUE;
    static int[][] w;
    static ArrayList<edgeSet> arr;
    static int n;

    static class edgeSet {
        private int v1;
        private int v2;

        public edgeSet(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "edgeSet{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    '}';
        }
    }

    public static void main(String[] args) {
        int n = 5;
        w = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 3, infi, infi},
                {0, 1, 0, 3, 6, infi},
                {0, 3, 3, 0, 4, 2},
                {0, infi, 6, 4, 0, 5},
                {0, infi, infi, 2, 5, 0}
        };
        arr = new ArrayList<>();

        prim(n, w, arr);

    }

    static public void prim(int n, int w[][], ArrayList<edgeSet> arr) {
        int vnear = 0, min = 0;
        edgeSet e;
        int nearset[] = new int[n + 1];
        int dist[] = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dist[i] = w[1][i];
            nearset[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 2; j <= n; j++) {
                if (dist[j] > 0 && min > dist[j]) {
                    min = dist[j];
                    vnear = j;
                }
            }
            arr.add(new edgeSet(nearset[vnear], vnear));
            dist[vnear] = -1;
            for (int j = 2; j <= n; j++) {
                if (dist[j] > w[j][vnear] && w[j][vnear] != 0) {
                    dist[j] = w[j][vnear];
                    nearset[j] = vnear;
                }
            }

        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }

    }
}

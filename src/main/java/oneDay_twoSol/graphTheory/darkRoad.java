package oneDay_twoSol.graphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class darkRoad {
    static class Edge implements Comparable<Edge> {
        private int v1, v2, dist;

        public Edge(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    }

    static int n, m, parent[];
    static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    int sum=0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            sum+=c;
            edges.add(new Edge(a, b, c));
        }
        int ans=0;
        Collections.sort(edges);
        for (Edge edge : edges) {
                int dist = edge.dist;
                int v1 = edge.v1;
                int v2 = edge.v2;
                if (find(v1) != find(v2)) {
                    union(v1,v2);
                    ans+=edge.dist;
                }
        }
        System.out.println(sum-ans);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;

    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }
}
/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
*/
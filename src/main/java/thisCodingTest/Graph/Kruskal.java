package thisCodingTest.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25

ret = 159
*/
public class Kruskal {
    static class Info implements Comparable<Info> {
        int v1, v2, weight;

        public Info(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info info) {
            return weight - info.weight;
        }
    }

    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        ArrayList<Info> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Info(v1, v2, w));
        }
        Collections.sort(list);
        int ans = 0;
        for (Info info : list) {
            if (find(info.v1) != find(info.v2)) {
                union(info.v1, info.v2);
//                System.out.println(info.v1+" "+info.v2);
                ans+=info.weight;
            }
        }
        System.out.println(ans);


    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int v) {
        if (parent[v] == v)
            return v;
        return parent[v] = find(parent[v]);
    }
}

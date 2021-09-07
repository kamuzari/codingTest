package tues_thurs_sat._202105._20210515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WeightLimit_Kruskal {
    static class Node implements Comparable<Node> {
        private int v1, v2, w;

        public Node(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return o.w - w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", w=" + w +
                    '}';
        }
    }

    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;
        parent = new int[n + 1];
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> list[] = new ArrayList[n];
        for (int i = 1; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a, b, w));
        }
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
//        System.out.println(pq);
        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (!pq.isEmpty()) {

            if (find(s) == find(e)) {
                    break;
            } else {
                Node node = pq.poll();
                union(node.v1, node.v2);
                answer=node.w;
            }
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[b] = a;
        } else
            parent[a] = b;
    }
}

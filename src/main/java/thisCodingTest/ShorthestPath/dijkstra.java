package thisCodingTest.ShorthestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class dijkstra {
    static class Node implements Comparable<Node> {
        private int idx;
        private int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (weight == o.weight)
                return idx - o.idx;
            return weight - o.weight;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int dist[];
    static boolean visited[];
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(v1).add(new Node(v2, w));
        }

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        int startVertax = 1;
        // 데이크스트라
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertax, 0));
        dist[startVertax] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.idx] < cur.weight)
                continue;

            for (int i = 0; i < list.get(cur.idx).size(); i++) {
                int cost=dist[cur.idx]+list.get(cur.idx).get(i).weight;
                if(cost<dist[list.get(cur.idx).get(i).idx])
                {
                    dist[list.get(cur.idx).get(i).idx]=cost;
                    pq.offer(new Node(list.get(cur.idx).get(i).idx,cost));
                }
            }

        }

        System.out.println(Arrays.toString(dist));
    }
}

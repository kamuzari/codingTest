package oneDay_twoSol.shortestDIstance.InBook;

import java.util.*;
/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
public class Hide_And_seek {
    static int INF = (int) 1e9;
    static int n, m, d[];
    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

    static class Node implements Comparable<Node>{
        private int vertax;
        private int weight;

        public Node(int vertax, int w) {
            this.vertax = vertax;
            this.weight = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        d = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 양방향.
            adjList.get(a).add(new Node(b, 1));
            adjList.get(b).add(new Node(a, 1));
        }
        Arrays.fill(d, INF);
        d[0] = 0;
        int start = 1;
        dijkstra(start);
//        System.out.println(Arrays.toString(d));
        Vector<Integer> vector = new Vector<>();
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (max < d[i]) {
                vector.clear();
                max=d[i];
                vector.add(i);
            } else if (max == d[i])
                vector.add(i);
        }
        System.out.println(vector.get(0)+" "+max+" "+vector.size());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.vertax;
            int dist = node.weight;
            if (d[cur] < dist)
                continue;
            for (int i = 0; i < adjList.get(cur).size(); i++) {
                int cost = d[cur] + adjList.get(cur).get(i).weight;
                if (cost < d[adjList.get(cur).get(i).vertax]) {
                    d[adjList.get(cur).get(i).vertax] = cost;
                    pq.add(new Node(adjList.get(cur).get(i).vertax, cost));
                }

            }

        }
    }
}


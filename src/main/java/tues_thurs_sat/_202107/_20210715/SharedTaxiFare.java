package tues_thurs_sat._20210715;

import java.util.*;

public class SharedTaxiFare {
    // 88점.

    public static void main(String[] args) {
        int fares[][] = {
//                {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}
        };
//        System.out.println(solution(6,4,6,2,fares));
        System.out.println(solution(7, 3, 4, 1, fares));
    }

    static class Node implements Comparable<Node> {
        private int v, cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int dist[][];
    static int INF = (int) 1e9;
    static boolean v[];
    static List<List<Node>> adjList = new LinkedList<>();
    static int Start, A, B;
    private static int answer;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        answer = Integer.MAX_VALUE;
        Start = s;
        A = a;
        B = b;
        dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            adjList.add(new LinkedList<>());
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < fares.length; i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];
            adjList.get(v1).add(new Node(v2, cost));
            adjList.get(v2).add(new Node(v1, cost));
        }
        dijkstra(Start);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            if (i != Start) {
                if (dist[Start][i] != INF)
                    map.put(i, dist[Start][i]);
            }
        }
//        ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
//        arrayList.sort((o1, o2) -> map.get(o1) - map.get(o2));
//      /*  for (Integer key : arrayList) {
//            System.out.println(String.format("Key : %s, Value : %s", key, map.get(key)));
//        }*/
        for (Integer vertaxNumber : map.keySet()) {
            dijkstra(vertaxNumber);
        }

        return answer;
    }

    public static void dijkstra(int startVertax) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertax, 0));
        dist[startVertax][startVertax] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int weigth = cur.cost;
            if (dist[startVertax][cur.v] < weigth)
                continue;
            for (Node next : adjList.get(cur.v)) {
                int cost = dist[startVertax][cur.v] + next.cost;
                if (cost < dist[startVertax][next.v]) {
                    dist[startVertax][next.v] = cost;
                    pq.offer(new Node(next.v, cost));
                }
            }
        }
        answer = Math.min(answer, dist[startVertax][A] + dist[startVertax][B] + dist[Start][startVertax]);
//        System.out.println(Arrays.toString(dist[startVertax]));
    }
}

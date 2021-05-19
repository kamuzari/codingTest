package WeeklyThuseday.silver3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeisBecame그머 {
    static class Node implements Comparable<Node> {
        private int vertax;
        private int weight;

        public Node(int vertax, int weight) {
            this.weight = weight;
            this.vertax = vertax;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
    static int n, m, distance[];
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int dest = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = 1;
            // 양방향이라는 것이 없네. 예제입력 2번째에서 나옴.
            adjList.get(a).add(new Node(b, 1));
            adjList.get(b).add(new Node(a, 1));
        }
        Arrays.fill(distance, INF);
        System.out.println(Dijkstra(start, dest));
//        foo(start);
//        if (distance[dest] ==INF)
//            System.out.println(-1);
//        else
//            System.out.println(dist@ance[dest]);
    }

    static int Dijkstra(int start, int dest) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int w = cur.weight;
            if (distance[cur.vertax] < w)
                continue;
            for (Node node : adjList.get(cur.vertax)) {
                int cost = distance[cur.vertax] + node.weight;
                if (cost < distance[node.vertax]) {
                    distance[node.vertax] = cost;
                    pq.offer(new Node(node.vertax, cost));
                }
            }
        }
        if (distance[dest] ==INF)
            return -1;
        else
            return distance[dest];
    }
    public static void foo(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.vertax;
            int dist = node.weight;
            if (distance[cur] < dist)
                continue;
            for (int i = 0; i < adjList.get(cur).size(); i++) {
                int cost = distance[cur] + adjList.get(cur).get(i).weight;
                if (cost < distance[adjList.get(cur).get(i).vertax]) {
                    distance[adjList.get(cur).get(i).vertax] = cost;
                }

            }

        }
    }
}

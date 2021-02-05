package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShotestPath {
    static class Node implements Comparable<Node>{
        private int vetax;
        private int w;

        @Override
        public int compareTo(Node o) {
            return this.w -o.w;
        }

        public Node(int vetax, int edge) {
            this.vetax = vetax;
            this.w = edge;
        }
    }

    static ArrayList<ArrayList<Node>> adjList;
    static int v, e, d[];
    static final int INF=(int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        int start = sc.nextInt();

        adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        d = new int[v + 1];
        Arrays.fill(d,INF);
        for (int i = 0; i < e; i++) {
            adjList.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
        }
        dijkstra(start);

        for (int i = 1; i < v + 1; i++) {
            if (d[i] == INF)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.w;
            int number = node.vetax;
            if (d[number] < dist)
                continue;
            for (int i = 0; i < adjList.get(number).size(); i++) {
                int w = d[number] + adjList.get(number).get(i).w;
                if (w<d[adjList.get(number).get(i).vetax]) {
                    d[adjList.get(number).get(i).vetax] = w;
                    pq.add(new Node(adjList.get(number).get(i).vetax, w));
                }
            }
        }
    }
}


/*
3 2
3
1 3 10
2 1 4
 */

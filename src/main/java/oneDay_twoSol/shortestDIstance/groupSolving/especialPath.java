package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class especialPath {
    static class Node implements Comparable<Node> {
        private int v;
        private int w;

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

        public Node(int vetax, int edge) {
            this.v = vetax;
            this.w = edge;
        }
    }
   static int path1,path2;
    static ArrayList<ArrayList<Node>> adjList;
    static int v, e, d[];
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        d = new int[v + 1];
        for (int i = 0; i < e; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            // 무방향
            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

        path1=sc.nextInt();
        path2=sc.nextInt();
        long ans1=0;
        long ans2=0;

        ans1+=dijkstra(1,path1);
        ans1+=dijkstra(path1,path2);
        ans1+=dijkstra(path2,v);

        ans2+=dijkstra(1,path2);
        ans2+=dijkstra(path2,path1);
        ans2+=dijkstra(path1,v);

        if(ans1>=INF && ans2>=INF )
        {
            System.out.println(-1);
        }
        else
        {
            long min=Math.min(ans1,ans2);
            System.out.println(min);
        }
    }


    public static int dijkstra(int start,int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(d, INF);
        d[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.w;
            int number = node.v;
            if (d[number] < dist)
                continue;
            for (int i = 0; i < adjList.get(number).size(); i++) {
                int cost = d[number] + adjList.get(number).get(i).w;
                if (cost < d[adjList.get(number).get(i).v]) {
                    d[adjList.get(number).get(i).v] = cost;
                    pq.add(new Node(adjList.get(number).get(i).v, cost));
                }
            }
        }
        return d[target];
    }
}

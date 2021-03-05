package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// 다익스트라 방식의 최단거리
public class specialCitySearch {
    // 단방향
    static class Node implements Comparable<Node>{
        private int idx,dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return dist-o.dist;
        }
    }
    static int n,m,k,x;
    static int dist[];
    static final int INF=(int)1e9;
    static ArrayList<ArrayList<Node>> adjList =new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
         m=sc.nextInt();
         k=sc.nextInt();
         x=sc.nextInt();
        dist=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int vertax=sc.nextInt();
            int vertax2=sc.nextInt();
            int w=1;
            adjList.get(vertax).add(new Node(vertax2,w));
        }
        Arrays.fill(dist,INF);
        dijkstra(x);
//        System.out.println(Arrays.toString(dist));
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(k==dist[i])
                res.add(i);
        }
        if(res.isEmpty())
            System.out.println(-1);
        else
        {
            for (Integer r : res) {
                System.out.println(r);
            }
        }
    }
    public static void dijkstra(int start)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start]=0;
        while (!pq.isEmpty())
        {
            Node cur=pq.poll();
            if(dist[cur.idx]<cur.dist)
                continue;

            for (int i = 0; i < adjList.get(cur.idx).size(); i++) {
                int cost=dist[cur.idx]+adjList.get(cur.idx).get(i).dist;
                if(cost<dist[adjList.get(cur.idx).get(i).idx])
                {
                    dist[adjList.get(cur.idx).get(i).idx]=cost;
                    pq.offer(new Node(adjList.get(cur.idx).get(i).idx,cost));
                }
            }
        }
    }
}

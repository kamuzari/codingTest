package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 방향 그래프
public class BOJ1753_ShortestPath {
    static final int INF=(int)1e9;
    static class Node implements Comparable<Node>{
        private int vertex,dist;
        public Node(int vertex, int dist){
            this.vertex = vertex;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node comp){
            return this.dist-comp.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        List<Node> list[]=new List[n+1];
        for (int i = 1; i <n+1 ; i++) {
            list[i]=new ArrayList<>();
        }
        int startVertex=Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,dist));
        }
        int dist[]=dijkstra(n,startVertex,list);
        for (int i = 1; i <n+1; i++) {
            System.out.println(dist[i]==INF ? "INF" : dist[i]);
        }
    }
    public static int[] dijkstra(int n,int start,List<Node> adj[]){
        int dist[]=new int[n+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.vertex]<cur.dist) continue;
            for(Node next : adj[cur.vertex]){
                int distance=dist[cur.vertex]+next.dist;
                if(distance<dist[next.vertex]){
                    dist[next.vertex]=distance;
                    pq.offer(new Node(next.vertex,distance));
                }
            }
        }
        return dist;
    }
}

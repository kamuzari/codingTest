package BaekJoon.SolvedAC4;

import java.io.*;
import java.util.*;

public class BOJ1967_TreeLength {
    static class Node implements Comparable<Node>{
        private int v,dist;
        public Node(int v,int dist){
            this.v=v;
            this.dist=dist;
        }

        @Override
        public int compareTo(Node comp){
            return this.dist-comp.dist;
        }
    }
    public static final int INF=(int)1e9;
    public static final int ROOT=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        List<Node> list[]=new List[n+1];
        for(int i=1; i<n+1; i++){
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i <n-1; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,dist));
            list[to].add(new Node(from,dist));
        }
        int[] dist=dijkstra(n,ROOT,list);
        int nextVertex=soFarVertex(dist,ROOT);
        dist=dijkstra(n,nextVertex,list);
        int finalVertex=soFarVertex(dist,nextVertex);
        int answer=dist[finalVertex];
        System.out.println(answer==INF ? "0":answer);
    }
    public static int[] dijkstra(int n,int start,List<Node> list[]){
        int distance[]=new int[n+1];
        Arrays.fill(distance,INF);
        distance[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while (!pq.isEmpty()){
            Node cur=pq.poll();
            if(distance[cur.v]<cur.dist) continue;
            if(list[cur.v]==null) continue;
            for(Node next : list[cur.v]){
                int cost=distance[cur.v]+next.dist;
                if(cost<distance[next.v]){
                    distance[next.v]=cost;
                    pq.offer(new Node(next.v,cost));
                }
            }
        }
        return distance;
    }
    public static int soFarVertex (int dist[],int start){
        int vertex=0;
        int maxDist=0;
        for(int i=1; i<dist.length;i++){
            if(i==start) continue;
            if(maxDist<dist[i]){
                vertex=i;
                maxDist=dist[i];
            }
        }
        return vertex;
    }
}

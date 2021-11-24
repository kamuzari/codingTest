package BaekJoon.SolvedAC4;

import java.io.*;
import java.util.*;
// INF 가 10억이라 3개 이상 출연할 시 바로 int형 범위 초과로 인해 INF 보다 범위가 작아져 출력이 될 수 있음.
public class BOJ1504_EspecialShortestPath {
    static final int INF=(int)1e9; // : = 10억
    static class Node implements Comparable<Node>{
        private int v,dist;

        public Node(int v,int dist){
            this.v = v;
            this.dist=dist;
        }
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
        for (int i = 1; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());

            list[from].add(new Node(to,dist));
            list[to].add(new Node(from,dist));
        }
        st=new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());
        long answer1=0;
        int dist[]=dijkstra(1,list);
        answer1+=dist[v1];
        dist=dijkstra(v1,list);
        answer1+=dist[v2];
        dist=dijkstra(v2,list);
        answer1+=dist[n];

        long answer2=0;
        int dist2[]=dijkstra(1,list);
        answer2+=dist2[v2];
        dist2=dijkstra(v2,list);
        answer2+=dist2[v1];
        dist2=dijkstra(v1,list);
        answer2+=dist2[n];
        if(answer1>=INF && answer2>=INF){
            System.out.println(-1); return;
        }
        long answer=Math.min(answer1,answer2);
        System.out.println(answer);
    }
    public static int[] dijkstra(int start, List<Node>[] list){
        int dist[]=new int[list.length];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while (!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(dist[cur.v]<cur.dist) continue;

            for(Node next : list[cur.v]){
                int distance=dist[cur.v]+next.dist;
                if(distance<dist[next.v]){
                    dist[next.v]=distance;
                    pq.offer(new Node(next.v,distance));
                }
            }
        }

        return dist;
    }
}

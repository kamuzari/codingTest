package tues_thurs_sat._202104._20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Hacking  {
    static class Node implements Comparable<Node>{
        int idx,dist;

        public Node(int v, int dist) {
            this.idx = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return dist-node.dist;
        }
    }
    static int n,d,c;
    static ArrayList<ArrayList<Node>> adj;
    static int dist[];
    static int INF=100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        while (T-->0)
        {
            String str[]=br.readLine().split(" ");
            n=Integer.parseInt(str[0]);
            adj=new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                adj.add(new ArrayList<>());
            }
            dist=new int[n+1];
            Arrays.fill(dist,INF);
            d=Integer.parseInt(str[1]);
            c=Integer.parseInt(str[2]);
            for (int i = 0; i < d; i++) {
                str=br.readLine().split(" ");
                int a=Integer.parseInt(str[0]);
                int b=Integer.parseInt(str[1]);
                int s=Integer.parseInt(str[2]);
                adj.get(b).add(new Node(a,s));
//                adj.get(a).add(new Node(b,s));
            }

            dijkstra(c);
            int cnt=0;
            int max=-1;
            for (int i = 1; i < n+1; i++) {
                if(dist[i]==INF)
                    continue;
                cnt++;
                max = Math.max(max, dist[i]);
            }
          sb.append(cnt+" "+max).append("\n");
        }
        System.out.println(sb);
    }
    static void dijkstra(int v)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(v,0));
        dist[v]=0;
        while (!pq.isEmpty())
        {
            Node cur=pq.poll();

            if(dist[cur.idx]< cur.dist)
                continue;
            for (int i = 0; i < adj.get(cur.idx).size(); i++) {
                int cost=dist[cur.idx]+adj.get(cur.idx).get(i).dist;
                if(cost<dist[adj.get(cur.idx).get(i).idx])
                {
                    dist[adj.get(cur.idx).get(i).idx]=cost;
                    pq.offer(new Node(adj.get(cur.idx).get(i).idx,cost));
                }
            }
        }
    }
}

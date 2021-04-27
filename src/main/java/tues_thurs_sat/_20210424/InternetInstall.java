package tues_thurs_sat._20210424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class InternetInstall {
    static int n,p,k;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        list=new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        p=Integer.parseInt(s[1]);
        k=Integer.parseInt(s[2]);
        int max=-1;
        for (int i = 0; i < p; i++) {
            s=br.readLine().split(" ");
            int start=Integer.parseInt(s[0]);
            int e=Integer.parseInt(s[1]);
            int w=Integer.parseInt(s[2]);
            list[start].add(new Node(e,w));
            list[e].add(new Node(start,w));
            max=Math.max(max,w);
        }

        int first=0;
        int last=max;
        int ans=Integer.MIN_VALUE;
        while (first<=last)
        {
            int m=(first+last)/2;
            if(dijkstra(m))
            {
                ans=m;
                last=m-1;
            }
            else
                first=m+1;
        }
        if(ans==INF)
            System.out.println("-1");
        else
            System.out.println(ans);

    }
    static int INF=Integer.MAX_VALUE;
    static boolean dijkstra(int v)
    {
        int dist[]=new int[n+1];
        Arrays.fill(dist,INF);
        dist[1]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while (!pq.isEmpty())
        {
            Node cur=pq.poll();

            if(dist[cur.idx]<cur.cost)
                continue;

            for (Node node : list[cur.idx]) {
                int w=cur.cost;
                if(node.cost>v)
                {
                    w++;
                }
                if(w<dist[node.idx])
                {
                    dist[node.idx]=w;
                    pq.offer(new Node(node.idx,w));
                }

            }
        }
        System.out.println("v = " + v);
        System.out.println(Arrays.toString(dist));
        return dist[n]<=k;
    }
    static class Node implements Comparable<Node>{
        private int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost-node.cost;
        }
    }
}

package tues_thurs_sat._20210424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class InternetInstall {
    static int n,p,k;
    static ArrayList<ArrayList<Node>> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        p=Integer.parseInt(s[0]);
        for (int i = 0; i < p; i++) {
            s=br.readLine().split(" ");
            int start=Integer.parseInt(s[0]);
            int e=Integer.parseInt(s[0]);
            int w=Integer.parseInt(s[0]);
            list.get(start).add(new Node(e,w));
            list.get(e).add(new Node(start,w));
        }
        k=Integer.parseInt(s[0]);

    }
    static int INF=(int)1e9;
    static void dijkstra(int v)
    {
        int dist[]=new int[n+1];
        Arrays.fill(dist,INF);
        dist[1]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while (!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(dist[cur.idx]<cur.w)
                continue;

            for (int i = 0; i <list.get(cur.idx).size() ; i++) {
                
            }
        }
    }
    static class Node{
        private int idx,w;

        public Node(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }
}

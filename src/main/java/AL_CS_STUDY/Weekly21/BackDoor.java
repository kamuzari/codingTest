package AL_CS_STUDY.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BackDoor {
    static class Node implements Comparable<Node>{
        private int idx;
        private long weigh;
        boolean insight;

        public Node(int idx, long weigh,boolean insight) {
            this.idx = idx;
            this.weigh = weigh;
            this.insight=insight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)weigh-(int)o.weigh;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", weigh=" + weigh +
                    ", insight=" + insight +
                    '}';
        }
    }
    static int n,m;
    static ArrayList<Node> list[];
    static long dist[];
    static final long INF=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        list=new ArrayList[n];
        m=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            list[i]=new ArrayList<>();
        }
        boolean sight[]=new boolean[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a==1)
            {
                sight[i]=true;
            }
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int v1=Integer.parseInt(st.nextToken());
            int v2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v2,w,sight[v2]));
            list[v2].add(new Node(v1,w,sight[v1]));
        }
        dist=new long[n+1];
        Arrays.fill(dist,  INF);
        int startVertax=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(startVertax,0,false));
        dist[startVertax]=0;
        while (!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(dist[cur.idx]<cur.weigh)
                continue;
            for (int i = 0; i < list[cur.idx].size(); i++) {
                long cost=dist[cur.idx]+list[cur.idx].get(i).weigh;
                boolean flag=list[cur.idx].get(i).insight;
                if(list[cur.idx].get(i).idx==n-1)
                {
                    flag=false;
                }
                if(cost<dist[list[cur.idx].get(i).idx] && !flag)
                {
                    dist[list[cur.idx].get(i).idx]=cost;
                    pq.offer(new Node(list[cur.idx].get(i).idx,cost,list[cur.idx].get(i).insight));
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        long answer=dist[n-1];
        if(answer==INF)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}

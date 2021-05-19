package WeeklyThuseday._0519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//  E log (v)
public class FindingMinimumCost {
    static class Node implements Comparable<Node> {
        private int v;
        private long weight;

        public Node(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return (int)weight - (int)o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }

    static int n, m;
    static ArrayList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        System.out.println(Dijksta(start, target));
    }

    private static long Dijksta(int start, int target) {
        long answer = 0;
        long INF=Long.MAX_VALUE;
        long dist[]=new long[n+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        while (!pq.isEmpty())
        {

            Node cur = pq.poll();
            if(dist[cur.v]<cur.weight)
                continue;
            for (int i = 0; i < list[cur.v].size(); i++) {
                long cost=dist[cur.v]+list[cur.v].get(i).weight;
                if(cost<dist[list[cur.v].get(i).v])
                {
                    dist[list[cur.v].get(i).v]=cost;
                    pq.offer(new Node(list[cur.v].get(i).v,cost));
                }
            }
        }
        answer=dist[target];
        return answer;

    }

}

package Programmers.ProgrammersKit.SummerIntern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Delivery {
    static class Node implements Comparable<Node>{
        private int idx,cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return cost-node.cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF=(int)1e9;
        int dist[]=new int[N+1];

        ArrayList<Node> list[]=new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int a=road[i][0];
            int b=road[i][1];
            int c=road[i][2];
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        Arrays.fill(dist,INF);
        dist[0]=dist[1]=0;

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while (!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(dist[cur.idx]<cur.cost)
                continue;

            for (int i = 0; i < list[cur.idx].size(); i++) {
                int cost=dist[cur.idx]+list[cur.idx].get(i).cost;
                if(cost<dist[list[cur.idx].get(i).idx])
                {
                    dist[list[cur.idx].get(i).idx]=cost;
                    pq.offer(new Node(list[cur.idx].get(i).idx,cost));
                }
            }
        }
        for (int i = 1; i <N+1 ; i++) {
            if(dist[i]<=K)
                answer++;
        }
        return answer;
    }
}

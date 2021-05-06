package tues_thurs_sat._20210506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Delivery  {
    public static void main(String[] args) {
        int r[][]=
                {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(solution(5,r,3));

    }
    static class Node implements Comparable<Node>{
        private int idx,weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight-node.weight;
        }
    }
    public static int solution(int N, int[][] road, int K) {
        int INF=(int)1e9;
        int answer = 0;
        int dist[]=new int[N+1];
        ArrayList<Node> list[]=new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            list[i]=new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
                int v1=road[i][0];
                int v2=road[i][1];
                int w=road[i][2];
                list[v1].add(new Node(v2,w));
                list[v2].add(new Node(v1,w));
        }

        Arrays.fill(dist,INF);
        int start=1;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start]=0;
        while (!pq.isEmpty())
        {
            Node cur=pq.poll();
            if(dist[cur.idx]<cur.weight)
                continue;

            for (int i = 0; i < list[cur.idx].size(); i++) {
                int cost=dist[cur.idx]+list[cur.idx].get(i).weight;
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

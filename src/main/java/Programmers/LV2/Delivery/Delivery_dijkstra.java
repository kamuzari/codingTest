package Programmers.LV2.Delivery;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery_dijkstra {// E log v == 2000 log 50; == 10,000 == 100,000,000 == 0.001 초
    class Node implements Comparable<Node>{
        private int v,cost;

        public Node(int v,int cost){
            this.v=v;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o){
            return cost-o.cost;
        }

    }
    private List<Node> list[];
    private final int INF=Integer.MAX_VALUE;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        list=new List[N+1];
        for(int i=1; i<N+1; i++){
            list[i]=new LinkedList<>();
        }
        int n=road.length;
        for(int i=0; i<n; i++){
            int from = road[i][0];
            int to=road[i][1];
            int cost=road[i][2];
            list[from].add(new Node(to,cost));
            list[to].add(new Node(from,cost));
        }
        int dist[]=dijkstra(1,new int[N+1]);
        System.out.println(Arrays.toString(dist));
        for(int i=1; i<N+1; i++){
            if(dist[i]<=K){
                answer++;
            }
        }
        return answer;
    }
    private int[] dijkstra(int start,int dist[]){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,0));
        Arrays.fill(dist,INF);
        dist[start]=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(dist[cur.v]<cur.cost)
                continue;

            for(Node next : list[cur.v]){
                int distance=dist[cur.v]+next.cost;
                if(distance<dist[next.v]){
                    dist[next.v]=distance;
                    pq.offer(new Node(next.v,distance));
                }
            }
        }

        return dist;
    }
}

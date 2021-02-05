package oneDay_twoSol.shortestDIstance.InBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Telegram {
    static final int INF = (int) 1e9;
    static int n,m,distance[];
    static ArrayList<ArrayList<Node>> adjList;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int start=sc.nextInt();
        adjList=new ArrayList<>();
        distance=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }
        Arrays.fill(distance, INF); // distance 초기화
        for (int i = 0; i < m; i++) {
            adjList.get(sc.nextInt()).add(new Node(sc.nextInt(),sc.nextInt()));
        }

        dijkstra(start);
        System.out.println(Arrays.toString(distance));
        int cnt=0;
        int maxDist=0;
        for(int k:distance) {
            if (k != INF && k != 0) {
                cnt++;
                if (maxDist < k)
                    maxDist = k;
            }
        }
        System.out.println(cnt+" "+maxDist);

    }

    private static void dijkstra(int vertax) {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(vertax,0));
        distance[vertax]=0;
        while (!pq.isEmpty())
        {
            Node node=pq.poll();
            int dist=node.getWeight();
            int cur=node.id;
            if(distance[cur]<dist)
            {
                continue;
            }
            for (int i = 0; i <adjList.get(cur).size() ; i++) {
                int cost=distance[cur]+adjList.get(cur).get(i).getWeight();

                if(cost<distance[adjList.get(cur).get(i).getId()])
                {
                   distance[adjList.get(cur).get(i).getId()]=cost;
                   pq.offer(new Node(adjList.get(cur).get(i).getId(),cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        private int id;
        private int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        public int getId() {
            return id;
        }

        public int getWeight() {
            return weight;
        }
        @Override
        public int compareTo(Node o) {
            if(this.weight==o.weight)
                return this.id-o.id;
            return this.weight-o.weight;
        }
    }
}

package AL_CS_STUDY.Weekly_30to40.Weekly38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2611_CarRace_OutOfMemory {

    private static int[] road;

    static class Node  implements Comparable<Node> {
        int vertex,weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return o.weight-this.weight;
        }
    }
    static List<Node> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        list=new List[n+1];
        for (int i = 1; i < n + 1; i++) {
            list[i]=new ArrayList<>();
        }
        road = new int[n+1];

        int dist[]=new int[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,w));
        }

        dist[1]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(1,0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.weight>=dist[cur.vertex]){
                for (Node node : list[cur.vertex]) {
                    int newCost=node.weight+dist[cur.vertex];
                    int nextVertex =node.vertex;
                    if(dist[nextVertex]<newCost){
                        dist[nextVertex]=newCost;
                        road[nextVertex]=cur.vertex;
                        if(nextVertex !=1){
                            pq.offer(new Node(nextVertex,newCost));
                        }
                    }
                }
            }
        }
        System.out.println(dist[1]);
        printRoad(1);
    }

    public static void printRoad(int r){
        if(road[r]==1){
            System.out.print("1 " +r+" ");
            return;
        }
        printRoad(road[r]);
        System.out.print(r+" ");
    }
}

package Basic.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1167_TreeLength {
    static final int INF=(int)1e9;
    static class Node implements Comparable<Node>{
        private int toV,dist;
        public Node(int toV, int dist){
            this.toV=toV;
            this.dist=dist;
        }

        public int compareTo(Node comp){
            return this.dist-comp.dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //다익스트라 2번 -> 정점에서 가장 먼거리 정점 -> 먼거링 정점에서 가장 먼 정점간 MAX거리
        List<Node> list[]=new List[n+1];
        for (int i = 1; i <=n; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int curV=Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int toV=Integer.parseInt(st.nextToken());
                if(toV==-1) break;
                int dist=Integer.parseInt(st.nextToken());
                list[curV].add(new Node(toV,dist));
            }
        }

        int dist[]=dijkstra(1,n,list);
        int max=0;
        int vertexFromRoot=0;
        for(int i=1; i<=n; i++){
            if(max<dist[i]){
                vertexFromRoot=i;
                max=dist[i];
            }
        }
        dist=dijkstra(vertexFromRoot,n,list);
        max=0;
        for (int i = 1; i <=n ; i++) {
            if(max<dist[i]){
                max=dist[i];
            }
        }
        System.out.println(max);
    }
    static int[] dijkstra(int startV,int n,List<Node> list[]){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int dist[]=new int[n+1];
        Arrays.fill(dist,INF);
        dist[startV]=0;
        pq.offer(new Node(startV,0));
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.dist>dist[cur.toV]) continue;
            for (Node next : list[cur.toV]) {
                int distance=dist[cur.toV]+ next.dist;
                if(distance<dist[next.toV]){
                    dist[next.toV]=distance;
                    pq.offer(new Node(next.toV,distance));
                }
            }
        }
        return dist;
    }
}

package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
// 1 -()-() > N
public class especialPath {
    static class Node implements Comparable<Node> {
        private int v;
        private int w;

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }

        public Node(int vetax, int edge) {
            this.v = vetax;
            this.w = edge;
        }
    }
   static int path1,path2;
    static ArrayList<ArrayList<Node>> adjList;
    static int v, e, d[];
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        d = new int[v + 1];
        for (int i = 0; i < e; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            // 무방향
            adjList.get(a).add(new Node(b, c));
            adjList.get(b).add(new Node(a, c));
        }

        path1=sc.nextInt();
        path2=sc.nextInt();
        long ans1=0;
        long ans2=0;

        ans1+=dijkstra(1,path1);
        ans1+=dijkstra(path1,path2);
        ans1+=dijkstra(path2,v);

        ans2+=dijkstra(1,path2);
        ans2+=dijkstra(path2,path1);
        ans2+=dijkstra(path1,v);

        if(ans1>=INF && ans2>=INF )
        {
            System.out.println(-1);
        }
        else
        {
            long min=Math.min(ans1,ans2);
            System.out.println(min);
        }
    }

    /*
    세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. --> MST가 아니다.
    실제적으로 단순히 가장 적은 간선을 사용한다고 해서 최소 비용이 얻어지는 것은 아니다.
    MST는 한번 이동했던 정점 그리고 간선을 다시 이동하는 경우가 없다.
    즉. 모든 정점들을 가장 적은 수의 간선과 비용으로 연결하는 것이  MST 다.
    다익스트라는 일정한 정점에서 도달하는 거리 출발지점이 어느정도 정해져 있어야하는 실세계 네비게이션 같은 경우에 사용된다.
    왜냐하면 현재 내가 위치하는 점(출발점)에서의 최단거리를 가지고 사용자에게 보여주여야 하므로 이다.

    MST에서는 이제 고속도로 의 설계 부분에서 쓰인다 여러 정점을 가진 도시 인천 , 서울, 경기도 로 넘나드는 도로를 건설하기 위해
    각 인천에서 최단거리로 갈수 있는 고속도로 , 서울에서 다른 도착지로 갈 수 있는 고속도로 등을 따로 만들면 비용과 시간은 어마어마할 것이다.
    하지만 모든 정점 그리고 거리 비용을 통합하여 고려하며 설계 될 때는 가장 적은수의 간선과 비용으로 연결하는 MST를 사용.
    */
    public static int dijkstra(int start,int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(d, INF);
        d[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.w;
            int number = node.v;
            if (d[number] < dist)
                continue;
            for (int i = 0; i < adjList.get(number).size(); i++) {
                int cost = d[number] + adjList.get(number).get(i).w;
                if (cost < d[adjList.get(number).get(i).v]) {
                    d[adjList.get(number).get(i).v] = cost;
                    pq.add(new Node(adjList.get(number).get(i).v, cost));
                }
            }
        }
        return d[target];
    }
}

package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11779_MinimumCost2 {

    private static final int INF = (int) 1e9;
    private static int path[];
    private static List<Node> list[];

    static class Node implements Comparable<Node> {
        private int vertex, cost;


        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node comp) {
            return this.cost - comp.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        path = new int[n + 1];
        initAdjList(n);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
        }
        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int arrivalVertex = Integer.parseInt(st.nextToken());

        int answerCost = dijkstra(startVertex, arrivalVertex, list);
        System.out.println(answerCost);
        printPath(arrivalVertex);
       /* 예외 상황 := StringBuilder 도시의 번호가 두자릿수 이상인 경우 reverse를 할 때 잘못 뒤집어짐..
        StringBuilder paths = new StringBuilder();
       while (current != 0) {
            paths.append(" " + current);
            size++;
            current = path[current];
        }
        System.out.println(paths.reverse().toString());
        */
    }

    private static void printPath(int arrival) {
        int current = arrival;
        List<Integer> pathResults = new LinkedList<>();
        while (current != 0) {
            pathResults.add(current);
            current = path[current];
        }
        System.out.println(pathResults.size());
        for (int i = pathResults.size() - 1; i >= 0; i--) {
            System.out.print(pathResults.get(i) + " ");
        }
    }

    private static int dijkstra(int start, int arrival, List<Node> adjList[]) {
        int dist[] = new int[adjList.length + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        path[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (dist[currentNode.vertex] < currentNode.cost) continue;
            for (Node next : list[currentNode.vertex]) {
                int newPathCost = dist[currentNode.vertex] + next.cost;
                if (dist[next.vertex] > newPathCost) {
                    dist[next.vertex] = newPathCost;
                    path[next.vertex] = currentNode.vertex;
                    pq.offer(new Node(next.vertex, newPathCost));
                }
            }
        }
        return dist[arrival];
    }

    private static void initAdjList(int n) {
        for (int i = 1; i < n + 1; i++) {
            list[i] = new LinkedList<>();
        }
    }
}
/*
2
2
1 1 0
1 2 1
1 2
*/

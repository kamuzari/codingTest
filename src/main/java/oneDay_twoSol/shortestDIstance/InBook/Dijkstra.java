package oneDay_twoSol.shortestDIstance.InBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
6
11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

// ans
[1000000000, 0, 2, 3, 1, 2, 4]
*/
public class Dijkstra {
    static class Node implements Comparable<Node> {
        private int number;
        private int weight;

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", weight=" + weight +
                    '}';
        }

        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        public int getNumber() {
            return number;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight==o.weight)
                return this.number-o.number;
            return this.weight-o.weight;
        }
    }

    static ArrayList<ArrayList<Node>> adjList;
    static int vertax, edge, start;
    static int distance[];
    static final int INF = (int) 1e9;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertax = sc.nextInt();
        edge = sc.nextInt();
        start = sc.nextInt();

        adjList = new ArrayList<>();
        distance = new int[vertax + 1];
        visited = new boolean[vertax + 1];

        // 인접리스트 생성.
        for (int i = 0; i < vertax + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // 인접리스트 주입.
        for (int i = 0; i < edge; i++) {
            int vertax = sc.nextInt();
            int vertax2 = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(vertax).add(new Node(vertax2, weight));
        }
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(adjList.get(i).toString());
        }

        Arrays.fill(distance, INF); // distance 초기화

//        dijkstra(start);
        improvedDijkstra(start);
        System.out.println(Arrays.toString(distance));
    }

    // 일반적인 다이제스트라
    public static void dijkstra(int start_vertax) {
        distance[start_vertax] = 0;
        visited[start_vertax] = true;
        // 테이블 갱신.
        for (int i = 0; i < adjList.get(start_vertax).size(); i++) {
            distance[adjList.get(start_vertax).get(i).getNumber()] = adjList.get(start_vertax).get(i).getWeight();
        }

        for (int i = 0; i < vertax; i++) {
            int current = smallVertaxSearch(); // 테이블에서 가장 작은  작은 weight을 가지는 vertax 찾기
            System.out.println(current);
            visited[current] = true;
            for (int j = 0; j < adjList.get(current).size(); j++) { // 가장 짧은 거리를 가지는 정점에서 그 다음으로 갈 수 있는 정점을 보면서 현재 테이블에서 가는 거리보다 짧은지 확인하고 갱신.
                int cost = distance[current] + adjList.get(current).get(j).weight;

                if (cost < distance[adjList.get(current).get(j).getNumber()]) {
                    distance[adjList.get(current).get(j).getNumber()] = cost;
                }

            }
        }
    }

    static int smallVertaxSearch() {
        int min = INF;
        int min_vertax = 0;
        for (int i = 1; i < vertax + 1; i++) {
            if (min > distance[i] && !visited[i]) {
                min = distance[i];
                min_vertax = i;
            }
        }
        return min_vertax;
    }

    public static void improvedDijkstra(int start_vertax)
    {
        PriorityQueue <Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start_vertax,0));
        distance[start_vertax]=0;
        while (!pq.isEmpty())
        {
            Node node=pq.poll();
            int dist=node.getWeight();
            int current_vertax =node.number;
            if(distance[current_vertax]<dist)
            {
                continue;
            }
            for (int i = 0; i < adjList.get(current_vertax).size(); i++) {
                int cost = distance[current_vertax] + adjList.get(current_vertax).get(i).weight;

                if (cost < distance[adjList.get(current_vertax).get(i).getNumber()]) {
                    distance[adjList.get(current_vertax).get(i).getNumber()] = cost;
                    pq.offer(new Node(adjList.get(current_vertax).get(i).getNumber(),cost));
                }

            }
        }
    }
}

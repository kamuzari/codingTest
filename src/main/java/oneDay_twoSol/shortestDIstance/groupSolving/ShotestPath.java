package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShotestPath {
    static class Node implements Comparable<Node>{
        private int vetax;
        private int w;

        @Override
        public int compareTo(Node o) {
            return this.w -o.w;
        }

        public Node(int vetax, int edge) {
            this.vetax = vetax;
            this.w = edge;
        }
    }

    static ArrayList<ArrayList<Node>> adjList;
    static int v, e, d[];
    static final int INF=(int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        int start = sc.nextInt();

        // 인접리스트 생성.(정점0은 입력에서 존재하지 않으므로 0 정점의 인접리스트는 사용하지 않는다)
        adjList = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            adjList.add(new ArrayList<>()); // 인접리스트 구조만 생성.
        }

        d = new int[v + 1]; // 시작 정점으로부터 도달할수 있는 거리의 값들을 가지고 있는 배열.
        Arrays.fill(d,INF);
        for (int i = 0; i < e; i++) {
            // 1번 입력 : 몇번 정점에서 -> 2번 입력: 몇번정점까지의 -> 3번 입력: 거리
            adjList.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
        }
        dijkstra(start); // 다익스트라 메소드 호출 : 기본 : 우선순위큐를 이용하여 nlog n 의 시간 복잡도 가짐.

        for (int i = 1; i < v + 1; i++) {
            if (d[i] == INF)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐는 정렬 기준이 있어야한다. 해당 객체의 속성2개 이상이면. Comparable
        d[start] = 0; // 시작점에서 시작점은 거리를 0으로 초기화.
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.w; // 정점까지 도달하는 거리값
            int number = node.vetax; // 정점의 번호
            if (d[number] < dist) // 기존에 테이블 d의 거리와 비교하여 이미 더 짧은 거리이면 넘어감.
                continue;
            for (int i = 0; i < adjList.get(number).size(); i++) { // 해당 정점에서 도달할 수 있는 모든 정점들의 크기만큼 순회
                int w = d[number] + adjList.get(number).get(i).w; // 해당 점점으로 도달하는 크기 + 다른 정점들을 거쳐 가는 길이를 더해 더 짧은 거리가 있으면 갱신
                if (w<d[adjList.get(number).get(i).vetax]) {
                    d[adjList.get(number).get(i).vetax] = w;
                    pq.add(new Node(adjList.get(number).get(i).vetax, w));
                }
            }
        }
    }
}


/*
3 2
3
1 3 10
2 1 4
 */

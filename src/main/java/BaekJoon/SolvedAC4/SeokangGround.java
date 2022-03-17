package BaekJoon.SolvedAC4;

import java.util.*;
import java.io.*;

public class SeokangGround {

    private static class Node {

        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    private static final int INF = (int) 1e9;
    private static int limitedDistance;
    private static int items[];
    private static List<Node> list[];

    public static void main(String[] args) throws IOException {

        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        limitedDistance = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        for (int start = 1; start <= n; start++) {
            answer = Math.max(bfs(start, new int[n + 1]), answer);
        }
        System.out.println(answer);
    }

    private static int bfs(int start, int[] dist) {
        int answer = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node next : list[cur.idx]) {
                int cost = dist[cur.idx] + next.dist;
                if (cost > dist[next.idx]) {
                    continue;
                }
                dist[next.idx] = cost;
                q.offer(new Node(next.idx, cost));
            }
        }

        for (int vertex = 0; vertex < dist.length; vertex++) {
            if (dist[vertex] <= limitedDistance) {
                answer += items[vertex];
            }
        }
        return answer;
    }


}

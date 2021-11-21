package Basic.SolvedAC4;

import java.io.*;
import java.util.*;

// 무방향 그래프
public class BOJ1865_WarmHole {
    static class Node {
        private int v1, v2, dist;

        public Node(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int warm = Integer.parseInt(st.nextToken());
            List<Node> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                edges.add(new Node(from, to, dist));
                edges.add(new Node(to, from, dist));
            }
            for (int i = 0; i < warm; i++) {
                st = new StringTokenizer(br.readLine());
                int e = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Node(e, s, -t));
            }
            int dist[] = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;
            boolean isUpdated = false;
            outer:
            for (int i = 1; i < n + 1; i++) {
                isUpdated = false;
                for (Node edge : edges) {
                    if (dist[edge.v2] >dist[edge.v1] + edge.dist) {
                        dist[edge.v2] = dist[edge.v1] + edge.dist;
                        isUpdated = true;
                        if (i==n) {
                            break outer;
                        }
                    }
                }
                if (!isUpdated) break;
            }
            answer.append(isUpdated ? "YES\n" : "NO\n");
        }
        System.out.println(answer);
    }
}

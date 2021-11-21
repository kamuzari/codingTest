package Basic.SolvedAC4.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class BellManFord {
    static class Node {
        private int v, dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", dist=" + dist +
                    '}';
        }
    }

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node> list[] = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int startVertex = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, dist));
        }
        int dist[] = CallBellManFord(n, startVertex, list);
        System.out.println(dist[0]==-1 ? "Negative Cycle!":Arrays.toString(dist));
    }

    public static int[] CallBellManFord(int n, int start, List<Node> adj[]) {
        int dist[] = new int[n + 1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        for (int i = 1; i <=n+1; i++) {
            for (int curV = 1; curV < n + 1; curV++) {
                for (Node next : adj[curV]) {
                    if (dist[next.v] < dist[curV] + next.dist) continue;

                    if (i == n) return new int[]{-1};
                    dist[next.v] = dist[curV] + next.dist;
                }
            }
        }
        return dist;
    }
}


/*
ref : https://devowen.com/250
4 4
1
1 2 2
2 3 3
3 2 -6
3 4 4
answer :  dijktra := INF-loop
*/
package tues_thurs_sat._202109._20210928;

import java.util.*;

public class PGM81304_MiroEscape {
    public static void main(String[] args) {
        final PGM81304_MiroEscape p = new PGM81304_MiroEscape();
        int[][] roads =new int[][]{
                {1,2,2},{3,2,3}
        };
        int traps[]=new int[]{2};
        final int answer = p.solution(3, 1, 3, roads, traps);
        System.out.println(answer);
    }
    private final static int MAX_VERTEX = 1001;
    private final static int INF = (int) 1e9;

    int[][] graph;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {

        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for (int[] row : roads) {
            int u = row[0], v = row[1], w = row[2];
            if (graph[u][v] > w) {
                // 가장 작은 간선만 update
                graph[u][v] = w;
            }
        }

        return dijkstra(n,start,end,traps);
    }

    class Node implements Comparable<Node> {
        private int idx, cost, state;

        public Node(int idx, int cost, int state) {
            this.idx = idx;
            this.cost = cost;
            this.state = state;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

    private int dijkstra(int n, int src, int dest, int traps[]) {
        final PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean v[][] = new boolean[n][1 << 10];
        pq.offer(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            final Node cur = pq.poll();

            if (cur.idx == dest)
                return cur.cost;

            if (v[cur.idx][cur.state]) continue;

            v[cur.idx][cur.state] = true;

            boolean curIsTrap = false;
            Set<Integer> trapped = new HashSet<>();
            for (int i = 0; i < traps.length; i++) {
                int bit = 1 << i;
                if ((cur.state & bit) != 0) // bit on : 함정 노드가 발동 된 상태라면
                {
                    // 원래대로 돌아가야함
                    if (traps[i] == cur.idx) {
                        cur.state &= ~bit; // bit off
                    } else {
                        trapped.add(traps[i]);
                    }
                } else {
                    if (traps[i] == cur.idx) {
                        cur.state |= bit;
                        trapped.add(traps[i]);
                        curIsTrap = true;
                    }
                }
            }

            for (int next = 1; next < n + 1; next++) {
                if (next == cur.idx) continue;
                boolean nextIsTrap = trapped.contains(next);
                if (curIsTrap == nextIsTrap) {
                    if (graph[cur.idx][next] != INF) {
                        pq.offer(new Node(next, cur.cost + graph[cur.idx][next], cur.state));
                    }
                } else {
                    if (graph[next][cur.idx] != INF) {
                        pq.offer(new Node(next, cur.cost + graph[next][cur.idx], cur.state));
                    }
                }
            }
        }
        return -1;
    }
}

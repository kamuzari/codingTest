package tues_thurs_sat._202105._20210515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightLimit_BFS_BinarySearch {
    static class Node {
        private int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static int n, m, max;
    static ArrayList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()) + 1;
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 1; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            max = Math.max(max, w);
            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        System.out.println(binary(from, to));
    }

    public static long binary(int from, int to) {
        long l = 1;
        long r = max;
        long mid = 0;
        long answer = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (bfs(from, to, mid)) {
                answer = Math.max(answer, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    public static boolean bfs(int from, int to, long w) {
        Queue<Integer> q = new LinkedList<>();
        boolean v[] = new boolean[n];
        q.offer(from);
        v[from] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == to) {
                return true;
            }
            for (Node node : list[cur]) {
                if (!v[node.v] && node.weight >= w) {
                    q.offer(node.v);
                    v[node.v] = true;
                }
            }
        }
        return false;
    }
}

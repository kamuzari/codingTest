package tues_thurs_sat._210619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Summit {
    static char map[][];
    static Node v[][][];
    static int dy[] = {-2, -1, 2, 1, 2, 1, -2, -1};
    static int dx[] = {-1, -2, -1, -2, 1, 2, 1, 2};
    private static int k;

    static class Node {
        private int idx, y, x, cnt;

        public Node(int idx, int y, int x, int cnt) {
            this.idx = idx;
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", y=" + y +
                    ", x=" + x +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        k = 0;
        LinkedList<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j].charAt(0);
                if (map[i][j] != '.') {
                    k = Math.max(map[i][j]-'0', k);
                    q.offer(new Node(map[i][j] - '0', i, j, 0));
                }
            }
        }
        v = new Node[k + 1][n][m];
        q.stream().forEach(node -> {
            v[node.idx][node.y][node.x] = new Node(node.idx, node.y, node.x, node.cnt);
        });
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur);
            if (check(cur.y, cur.x)) {
                min = Math.min(min, calc(cur));
            }

            for (int i = 0; i < 8; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;

                if (ny >= 0 && nx >= 0 && ny < n && nx < m && v[cur.idx][ny][nx]== null) {
                    q.offer(new Node(cur.idx,ny,nx,cur.cnt+1));
                    v[cur.idx][ny][nx]=new Node(cur.idx,ny,nx,cur.cnt+1);
                }


            }
        }
        System.out.println(min);

    }

    private static int calc(Node cur) {
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += v[i][cur.y][cur.x].cnt;
        }
        System.out.println(sum);
        return sum;
    }

    static boolean check(int y, int x) {
        for (int i = 1; i < k + 1; i++) {
            if (v[i][y][x] == null) {
                return false;
            }
        }
        return true;
    }


}

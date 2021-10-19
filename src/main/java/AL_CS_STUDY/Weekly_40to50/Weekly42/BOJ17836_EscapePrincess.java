package AL_CS_STUDY.Weekly_40to50.Weekly42;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ17836_EscapePrincess {

    private static int n;
    private static int m;
    private static int t;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        final int answer = solution();
        System.out.println(answer ==-1 ? "Fail":answer);
    }

    static class Node {
        int y, x, dist;
        int sword;

        public Node(int y, int x, int dist, int sword) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.sword = sword;
        }

    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    private static int solution() {
        int answer = 0;
        LinkedList<Node> q = new LinkedList<>();
        boolean v[][][] = new boolean[2][n][m];
        q.offer(new Node(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (t < cur.dist) {
                continue;
            }
            if (cur.y == n-1 && cur.x == m-1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (indexOutOf(ny, nx)) continue;
                if (v[cur.sword][ny][nx]) continue;

                if (cur.sword == 0) {
                    if (map[ny][nx] == 1) {
                        continue;
                    } else if (map[ny][nx] == 0) {
                        q.offer(new Node(ny, nx, cur.dist + 1, 0));
                    } else if (map[ny][nx] == 2) {
                        q.offer(new Node(ny, nx, cur.dist + 1, 1));
                    }
                } else if (cur.sword == 1) {
                    q.offer(new Node(ny, nx, cur.dist + 1, 1));
                }
                v[cur.sword][ny][nx] = true;
            }
        }
        return -1;
    }

    public static boolean indexOutOf(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}

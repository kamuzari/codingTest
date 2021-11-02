package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
모든 값이 0이면 -1인가?
*/
public class BOJ7569_Tomato {

    private static int[][] map;
    private static boolean[][] v;
    private static LinkedList<Node> q;

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n;
    private static int m;
    static int dy[] = {-1, 1, 0, 0, 0, 0};
    static int dx[] = {-0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[m][n];
        q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    q.offer(new Node(i, j));
                    v[i][j] = true;
                }
            }
        }
        BFS();
        int day = -2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !v[i][j]) {
                    System.out.println(-1);
                    return;
                } else {
                    day = Math.max(day, map[i][j]);
                }
            }
        }
        if (day == -1) {
            System.out.println(0);
        } else {
            System.out.println(day - 1);
        }

    }

    private static void BFS() {

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (indexOutOf(ny, nx)) continue;
                if (map[ny][nx] != 0) continue;

                map[ny][nx] = map[cur.y][cur.x] + 1;
                q.offer(new Node(ny, nx));
            }
        }
    }

    static boolean indexOutOf(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > m - 1 || nx > n - 1;
    }
}

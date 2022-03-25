package BaekJoon.SolvedAC4.WallBrokenAndMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WallBrokenAndMove_OOM {

    private static final int NOT_WALL = 0;
    private static final int WALL = 1;
    private static final int NOT_ACCESS =-1;
    private static int n;
    private static int m;
    private static int dy[] = {-1, 1, 0, 0};
    private static int dx[] = {0, 0, -1, 1};

    static class Node {

        private int y, x;
        private int dist;
        private boolean isBrokenYn;

        public Node(int y, int x, int dist, boolean isBrokenYn) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.isBrokenYn = isBrokenYn;
        }

        public boolean isBrokenYn() {
            return isBrokenYn;
        }

        public boolean isTargetPointYn() {
            return this.y == n - 1 && this.x == m - 1;
        }
    }

    /**
     * BUG : OOM
     * hint : 상태를 가져보자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(getMinimumDistance(map));
    }

    private static int getMinimumDistance(int[][] map) {
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, true));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.isTargetPointYn()) {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (isOutOfIndexYn(ny, nx)) {
                    continue;
                }
                if (isBrokenWallYn(map[ny][nx], cur)) {
                    q.offer(new Node(ny, nx, cur.dist + 1, false));
                } else if (map[ny][nx] == NOT_WALL) {
                    q.offer(new Node(ny, nx, cur.dist + 1, cur.isBrokenYn));
                }
            }
        }
        return NOT_ACCESS;
    }

    private static boolean isBrokenWallYn(int curPoint, Node cur) {
        return curPoint == WALL && cur.isBrokenYn;
    }

    private static boolean isOutOfIndexYn(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}

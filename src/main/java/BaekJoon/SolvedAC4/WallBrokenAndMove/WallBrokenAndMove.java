package BaekJoon.SolvedAC4.WallBrokenAndMove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WallBrokenAndMove {

    private static final int NOT_WALL = 0;
    private static final int WALL = 1;
    private static final int NOT_ACCESS = -1;
    private static final int STATUS = 2;
    private static int n;
    private static int m;
    private static int dy[] = {-1, 1, 0, 0};
    private static int dx[] = {0, 0, -1, 1};

    static class Node {

        private int y, x;
        private int dist;
        private int brokenCount;

        public Node(int y, int x, int dist, int brokenCount) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.brokenCount = brokenCount;
        }

        public boolean isBrokenYn() {
            return brokenCount < 1;
        }

        public boolean isTargetPointYn() {
            return this.y == n - 1 && this.x == m - 1;
        }
    }

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

    /**
     * bug : oom analyze : 방문 체크를 안하고 계속 방문에서 큐안에 노드들이 쌓이기 떄문에 그런것 같다. todo : 불필요한 노드 생성을 줄여야 한다. 방문
     * 배열은 두가지 상태를 가지고 있어야 한다! reason : 왜냐하면 마지막 도착지 주변이 무조건 벽을 부셔야 벽을 부셔서 빨리 왔을 뿐이고 돌아서 오는 노드만이
     * 도착점에 도달할 수 있으므로.
     */
    private static int getMinimumDistance(int[][] map) {
        LinkedList<Node> q = new LinkedList<>();
        boolean v[][][] = new boolean[STATUS][n][m];
        q.offer(new Node(0, 0, 1, 0));
        v[0][0][0] = true;
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
                    if (v[cur.brokenCount+1][ny][nx]) {
                        continue;
                    }
                    v[cur.brokenCount+1][ny][nx] = true;
                    q.offer(new Node(ny, nx, cur.dist + 1, cur.brokenCount + 1));
                } else if (map[ny][nx] == NOT_WALL) {
                    if (v[cur.brokenCount][ny][nx]) {
                        continue;
                    }
                    v[cur.brokenCount][ny][nx] = true;
                    q.offer(new Node(ny, nx, cur.dist + 1, cur.brokenCount));
                }
            }
        }
        return NOT_ACCESS;
    }

    private static boolean isBrokenWallYn(int curPoint, Node cur) {
        return curPoint == WALL && cur.isBrokenYn();
    }

    private static boolean isOutOfIndexYn(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}

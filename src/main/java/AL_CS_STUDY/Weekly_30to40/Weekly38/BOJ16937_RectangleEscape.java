package AL_CS_STUDY.Weekly_30to40.Weekly38;

import java.util.*;
import java.io.*;

public class BOJ16937_RectangleEscape {

    private static int n;
    private static int m;
    private static int h;
    private static int w;
    private static int[][] map;

    static class Node {
        private int y, x;
        private int dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        int answer = bfs(sy, sx, ey, ex, map);
        StringBuffer sb = new StringBuffer().append(answer);
        System.out.println(sb);
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    private static int bfs(int y, int x, int ey, int ex, int[][] map) {

        LinkedList<Node> q = new LinkedList<>();
        boolean v[][] = new boolean[n + 1][m + 1];
        v[y][x] = true;
        q.offer(new Node(y, x, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == ey && cur.x == ex) {
                return cur.dist;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (indexOutOfBound(ny, nx) || v[ny][nx] ||isWall(ny,nx)) {
                    continue;
                }
                if (!InnerIndexOutOfCheck(ny, nx)) {
                    continue;
                }
                q.offer(new Node(ny, nx, cur.dist + 1));
                v[ny][nx] = true;
            }
        }
        return -1;
    }

    public static boolean indexOutOfBound(int y, int x) {
        return y < 1 || x < 1 || y > n || x > m;
    }

    public static boolean isWall(int y,int x)
    {
        return map[y][x] == 1;
    }

    public static boolean InnerIndexOutOfCheck(int y, int x) {

        if (indexOutOfBound(y+h-1,x+w-1)) {
            return false;
        }
        for (int i = y; i < y + h; i++) {
            for (int j = x; j < x + w; j++) {
                if (isWall(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

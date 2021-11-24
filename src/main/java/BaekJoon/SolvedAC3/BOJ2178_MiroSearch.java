package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2178_MiroSearch {

    private static int n;
    private static int m;
    private static int map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    static class Node {
        private int y, x, dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        public boolean isExit() {
            return y == n - 1 && x == m - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        LinkedList<Node> q = new LinkedList<Node>();
        q.offer(new Node(0, 0, 1));
        boolean v[][]=new boolean[n][m];
        v[0][0]=true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.isExit()) {
                System.out.println(cur.dist);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (indexOutOf(ny, nx) || map[ny][nx]==0 || v[ny][nx]) continue;
                v[ny][nx]=true;
                q.offer(new Node(ny,nx,cur.dist+1));
            }
        }
        System.out.println(0);
    }

    public static boolean indexOutOf(int ny, int nx) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}

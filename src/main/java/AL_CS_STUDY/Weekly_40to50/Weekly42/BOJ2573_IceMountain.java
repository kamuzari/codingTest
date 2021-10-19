package AL_CS_STUDY.Weekly_40to50.Weekly42;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ2573_IceMountain {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = solution(n, m, map);
        System.out.println(answer);
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    private static boolean[][] v;
    private static int[][] melt;

    private static int solution(int n, int m, int[][] map) {
        melt = new int[n][m];
        v = new boolean[n][m];
        int answer = 0;
        while (true) {
            int cntArea = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !v[i][j]) {
                        bfs(i, j, n, m, map);
                        cntArea++;
                    }
                }
            }
            if (cntArea == 0) {
                return 0;
            } else if (cntArea >= 2) {
                return answer;
            }
            melting(n, m, map);
            answer++;
        }
    }

    private static void melting(int n, int m, int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    map[i][j] -= melt[i][j];
                    melt[i][j] = 0;
                    if (map[i][j] < 0) map[i][j] = 0;
                    v[i][j] = false;
            }
        }
    }


    public static void bfs(int y, int x, int n, int m, int map[][]) {
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        v[y][x] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (isIndexOutOf(ny, nx, n, m)) continue;
                if (v[ny][nx]) continue;
                if (map[ny][nx] == 0) {
                    melt[cur.y][cur.x]++;
                    continue;
                }
                v[ny][nx] = true;
                q.offer(new Node(ny, nx));
            }
        }

    }

    public static boolean isIndexOutOf(int ny, int nx, int n, int m) {
        return ny < 0 || nx < 0 || ny > n - 1 || nx > m - 1;
    }
}

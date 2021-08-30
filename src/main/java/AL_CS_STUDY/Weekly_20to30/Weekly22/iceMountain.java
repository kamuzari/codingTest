package AL_CS_STUDY.Weekly_20to30.Weekly22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class iceMountain {

    static int n;
    static int m;
    static int[][] map;
    static int[][] area;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        area = new int[n][m];
        melt = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (area[i][j] == 0 && map[i][j] != 0) {
                        areaDivide(i, j);
//                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            if (cnt == 0) {
                System.out.println(0);
                break;
            }
            else if(cnt>=2)
            {
                System.out.println(year);
                break;
            }
            melting();
            year++;
        }
    }

    private static void melting() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] -= melt[i][j];
                melt[i][j] = 0;

                if (map[i][j] < 0)
                    map[i][j] = 0;

                area[i][j] = 0;
            }
        }
    }



    static void areaDivide(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        area[y][x] = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur.y;
                int nx = dx[i] + cur.x;
                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                    if (map[ny][nx] != 0 && area[ny][nx] == 0) {
                        area[ny][nx] = 1;
                        q.offer(new Node(ny, nx));
                    }
                    if (map[ny][nx] == 0) {
                        melt[cur.y][cur.x]++;
                    }
                }
            }
        }
    }

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

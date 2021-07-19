package Basic.DFS_BFS.BFS;

import java.util.Scanner;

public class laboratory {
    static int n, m, map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        pick(0, 0, 0);
        System.out.println(zeroMax);

    }

    static int zeroMax = -1;

    static void pick(int y, int x, int cnt) {
        if (cnt == 3) {
            int temp[][] = copy();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2)
                        infection(i, j, temp);
                }
            }
            zeroMax = Math.max(inspection(temp), zeroMax);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    pick(i, j, cnt + 1);
                    map[i][j] = 0;

                }
            }
        }

    }

    static void infection(int y, int x, int temp[][]) {
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= n || nx >= m || ny < 0 || nx < 0 || temp[ny][nx] != 0)
                continue;
            temp[ny][nx] = 2;
            infection(ny, nx, temp);
        }
    }

    static int[][] copy() {
        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }

    static int inspection(int temp[][]) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static class Position {
        private int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}

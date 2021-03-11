package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.Scanner;

public class Laboratory {
    static int n, m, map[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int k = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
            }
        }

        wallConstruction(0);
        System.out.println(MaxStableCnt);
    }

    static int temp[][];
    static int MaxStableCnt=0;
    static void wallConstruction(int idx) {
        if (idx == k) {
            temp = copy();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2)
                        infection(i, j);
                }
            }
            int stableCnt = checkStableArea();
            MaxStableCnt=Math.max(stableCnt,MaxStableCnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wallConstruction(idx + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int checkStableArea() {
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static void infection(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                if (temp[ny][nx] == 0) {
                    temp[ny][nx] = 2;
                    infection(ny, nx);
                }
            }
        }
    }

    static int[][] copy() {
        int temp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }

        return temp;
    }

}

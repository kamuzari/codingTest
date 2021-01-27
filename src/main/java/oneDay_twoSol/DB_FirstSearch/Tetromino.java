package oneDay_twoSol.DB_FirstSearch;

import java.util.Scanner;

public class Tetromino {

    static int[][] ey = {{0, 0, 0, 1}, {1, 1, 1, 0}, {0, 1, 2, 1}, {0, 1, 2, 1}};
    static int[][] ex = {{0, 1, 2, 1}, {0, 1, 2, 1}, {1, 1, 1, 0}, {0, 0, 0, 1}};
    static int n, m;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    // 위 아래 왼쪽 오른쪽
    static int max;
    static int board[][];
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                except(i, j);
            }
        }
        System.out.println(max);
    }

    static void dfs(int y, int x, int depth, int sum) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tempY = y + dy[i];
            int tempX = x + dx[i];
            if (tempX >= 0 && tempY >= 0 && tempY < n && tempX < m) {
                if (!visited[tempY][tempX]) {
                    visited[tempY][tempX] = true;
                    dfs(tempY, tempX, depth + 1, sum + board[tempY][tempX]);
                    visited[tempY][tempX] = false;
                }
            }
        }
    }

    static void except(int y, int x) {
        int sum = 0;
        boolean check;
        for (int i = 0; i < 4; i++) {
            sum = 0;
            check = true;
            for (int j = 0; j < 4; j++) {
                int tempY = y + ey[i][j];
                int tempX = x + ex[i][j];
                if (tempX >= 0 && tempY >= 0 && tempY < n && tempX < m) {
                    sum += board[tempY][tempX];
                } else {
                    check = false;
                    break;
                }
            }
            if (check) {
                max = Math.max(max, sum);
            }
        }
    }

}

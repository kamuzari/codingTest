package oneDay_twoSol.Implementaion;

import java.util.Scanner;

public class RobotVacume {
    static int arr[][];
    static int n, m;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int cnt=1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // row
        m = sc.nextInt(); // col
        arr = new int[n][m];

        int y = sc.nextInt();
        int x = sc.nextInt();
        int direction = sc.nextInt();
        boolean flag=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int z = (sc.nextInt());
                if (z == 1) {
                    arr[i][j] = -1;
                    continue;
                }
                arr[i][j] = z;
            }
        }
            dfs(y, x, direction);
            System.out.println(cnt);
        }

    static void dfs(int y, int x, int direction) {

        arr[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;// 2.1현제 방향에서 왼쪽 을 먼저 본다.
            int tempY = dy[direction] + y;
            int tempX = dx[direction] + x;

            if (tempY >= 0 && tempY < n && tempX >= 0 && tempX < m && arr[tempY][tempX] == 0) {
                cnt++;
                dfs(tempY, tempX, direction);
                return;
            }
        }

        int back = (direction + 2) % 4; // 현재 방향에서 후진
        int tY = y + dy[back];
        int tX = x + dx[back];
        if (tY >= 0 && tY < n && tX >= 0 && tX < m && arr[tY][tX] != -1) {
            dfs(tY, tX, direction);
        }
    }
}


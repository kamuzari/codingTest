package oneDay_twoSol.Implementation2;

import java.util.Scanner;

public class devGame {
    static int n, m;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int board[][];
    static int curY, curX, curD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        curY = sc.nextInt();
        curX = sc.nextInt();
        curD = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        board[curY][curX]=-1;
        int cnt = 1;
        int turnCnt = 0;
        while (true) {
            turn();
            int ny = dy[curD] + curY;
            int nx = dx[curD] + curX;
            if (board[ny][nx] == 0) {
                board[ny][nx] = -1;
                curY = ny;
                curX = nx;
                cnt++;
                turnCnt = 0;
                continue;
            } else turnCnt++;
            if (turnCnt == 4) {
                ny = curY - dy[curD];
                nx = curX - dx[curD];
                if (board[ny][nx] == -1) {
                    curY = ny;
                    curX = nx;
                    turnCnt = 0;
                } else
                    break;
            }
        }
        System.out.println("cnt = " + cnt);

    }


    static void turn() {
        curD -= 1;
        if (curD < 0) curD = 3;
    }
}
/*
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
 */

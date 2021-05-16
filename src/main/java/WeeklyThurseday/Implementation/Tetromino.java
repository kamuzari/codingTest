package WeeklyThurseday.Implementation;

import java.util.Scanner;


public class Tetromino {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int max;
    static boolean visited[][];
    static int board[][];
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행
        m = sc.nextInt(); // 열
        board = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exception(i,j);
            }
        }
        System.out.println(max);
    }
    static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return ;
        }
        for (int i = 0; i < 4; i++) {
            int tempY = y + dy[i];
            int tempX = x + dx[i];
            if (0 <= tempX && tempX < m && 0 <= tempY && tempY < n && !visited[tempY][tempX]) {
                // 왓던길 다시 감.. 방문처리 해제
                visited[tempY][tempX] = true;
                dfs(tempY, tempX, depth + 1, sum + board[tempY][tempX]);
                visited[tempY][tempX] = false;
            }
        }
    }
    public static boolean isValid(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m)
            return false;
        return true;
    }
    private static void exception(int row, int col) {
        int wing = 4; // 가운데에서의 상하좌우 날개
        int min = Integer.MAX_VALUE;
        int sum = board[row][col];
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            // 날개가 2개이상 없다면 ㅗ 모양이 아니다. 그러므로 함수를 종료한다.
            if (wing <= 2)
                return;
            // 날개가 맵 바깥에 있는 경우
            if (!isValid(nextRow, nextCol)) {
                wing--;
                continue;
            }
            min = Math.min(min, board[nextRow][nextCol]);
            sum = sum + board[nextRow][nextCol];
        }
        // 날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }

}
/*
*
4 4
0 0 0 1
0 0 0 2
0 0 0 3
0 0 0 4
* */
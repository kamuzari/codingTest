package oneDay_twoSol.shortestDIstance.groupSolving;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Is_that_Zelda_in_the_green_suit {

    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n, map[][];
    static int dp[][];
    static int INF=(int)1e9;

    static class Node {
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=1;
        while (true) {
            n = sc.nextInt();
            if(n==0)
            {
                break;
            }
            map = new int[n][n];

            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String str[]=sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
            System.out.println("Problem "+T+++": "+bfs(0, 0));
        }
    }

    public static int bfs(int y, int x) {
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],INF);
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        dp[0][0]=map[0][0];

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curY = node.y;
            int curX = node.x;

            for (int i = 0; i < 4; i++) {
                int ty = curY + dy[i];
                int tx = curX + dx[i];
                if (ty >= 0 && tx >= 0 && ty < n && tx < n) {
                    if (dp[ty][tx] > dp[curY][curX] + map[ty][tx]) {
                        dp[ty][tx]=dp[curY][curX]+map[ty][tx];
                        q.add(new Node(ty, tx));
                    }
                }
            }
        }
        return dp[n - 1][n - 1];
    }

}

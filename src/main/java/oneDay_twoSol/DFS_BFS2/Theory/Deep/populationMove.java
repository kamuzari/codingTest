package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.Scanner;

public class populationMove {
    static int n, l, r;
    static int map[][];
    static int visited[][];
    static int cnt;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int ret = 0;
        boolean flag;
        do {
            flag = false;
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        cnt = 0;
                         dfs(i, j);
                         if(cnt>1)
                         {
                             flag=true;
//                             System.out.println(sum);
                             int ans=sum/cnt;

                             for (int k = 0; k < n; k++) {
                                 for (int m = 0; m < n; m++) {
                                     if(visited[k][m]==1)
                                     {
                                         map[k][m]=ans;
                                         visited[k][m]=2;
                                     }
                                 }
                             }
                         }
                         else
                         {
                             visited[i][j]=2;
                         }
                         sum=0;
                    }
                }
            }
            if(flag)
                ret++;

        } while (flag);
        System.out.println(ret);

    }


    static int sum=0;
    static void dfs(int y, int x) {
        visited[y][x] = 1;
        cnt++;
        sum+=map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < n && nx < n && visited[ny][nx] == 0) {
                int diff = Math.abs(map[y][x] - map[ny][nx]);
                if (diff >= l && diff <= r) {
                      dfs(ny, nx);
                }
            }
        }
    }

}

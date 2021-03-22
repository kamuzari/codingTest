package AL_CS_STUDY;

import java.util.Scanner;

public class Tetromino {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int max;
    static boolean visited[][];
    static int board[][];
    static int n, m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        board=new int[n][m];
        visited=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                visited=new boolean[n][m]; // 대칭적인 부분 그 이전에 탐색했던 부분을 재탐색하는데 시간이 걸린다.
                visited[i][j]=true;
                dfs(i,j,1,board[i][j]);
                visited[i][j]=false;
                except(i,j);
            }
        }
        System.out.println(max);

    }
    static void dfs(int y,int x,int cnt,int sum)
    {
        if(cnt==4)
        {
           max=Math.max(sum,max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(ny>=0 && nx>=0 && ny<n && nx<m && !visited[ny][nx])
            {
                visited[ny][nx]=true;
                dfs(ny,nx,cnt+1,sum+board[ny][nx]);
                visited[ny][nx]=false;
            }
        }
    }
    static void except(int y,int x)
    {
        int w=4;
        int min=Integer.MAX_VALUE;
        int sum=board[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (w < 3)
                return;
            if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
                min = Math.min(min, board[ny][nx]);
                sum += board[ny][nx];
            } else {
                w--;
            }

        }
        if(w==4)
            sum-=min;

        max=Math.max(max,sum);
    }
}

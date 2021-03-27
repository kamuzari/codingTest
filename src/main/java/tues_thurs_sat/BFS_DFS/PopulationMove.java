package tues_thurs_sat.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PopulationMove {
    static int n, r, l;
    static int map[][];
    static int visited[][];
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int totalMoveCnt=0;
        while (true) {

            visited=new int[n][n];
            int smallMove=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                  if(visited[i][j]==0)
                  {
                      cnt=0;
                      sum=0;
                      dfs(i, j);
                      if(cnt>1)
                      {
                          int val=sum/cnt;
                          move(val);
                          smallMove++;
                      }
                      else
                      {
                          visited[i][j]=2;
                      }
                  }
                }
            }

            if(smallMove==0)
            {
                break;
            }
            else
            {
                totalMoveCnt++;
            }
        }
        System.out.println(totalMoveCnt);


    }
    static int cnt;
    static int sum;
    static void move(int val)
    {
        for (int k = 0; k < n; k++) {
            for (int m = 0; m < n; m++) {
                if(visited[k][m]==1)
                {
                    visited[k][m]=2;
                    map[k][m]=val;
                }
            }
        }
    }
    public static void dfs(int y, int x) {
        visited[y][x]=1;
        cnt++;
        sum+=map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && nx >= 0 && nx < n && ny < n) {
                if (0==visited[ny][nx])
                {
                    int gap=Math.abs(map[ny][nx]-map[y][x]);
                    if(gap>=l && gap<=r)
                    {
                        dfs(ny,nx);
                    }
                }
            }
        }
    }
}

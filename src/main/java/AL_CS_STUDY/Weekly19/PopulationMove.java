package AL_CS_STUDY.Weekly19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class PopulationMove {
    static int n, l, r;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int map[][];
    static int visited[][];

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
        int answer = 0;
        while (true) {
            visited = new int[n][n];
            boolean flag=false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        cnt = 0;
                        sum = 0;
                        dfs(i, j);
                        if(cnt>1)
                        {
                            int val=sum/cnt;
                            move(val);
                            flag=true;
                        }
                        else
                        {
                            visited[i][j]=2;
                        }
                    }
                }
            }

            if(flag)
            {
                answer++;
            }
            else
            {
                break;
            }
        }
        System.out.println(answer);


    }

    static int cnt = 0;
    static int sum = 0;

    static void dfs(int y, int x) {
        visited[y][x] = 1;
        cnt++;
        sum += map[y][x];
        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if (ny >= 0 && nx >= 0 && ny<n &&nx<n)
            {
                if(visited[ny][nx]==0)
                {
                    int diff=Math.abs(map[ny][nx]-map[y][x]);
                    if(diff>=l && diff<=r)
                    {
                        dfs(ny,nx);
                    }
                }
            }
        }
    }
    static void move(int val)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==1)
                {
                    visited[i][j]=2;
                    map[i][j]=val;
                }
            }
        }
    }
}

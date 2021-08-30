package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class snailNumber {

    static int n, map[][];
    static int dy[] = {0, 1, 0, -1};
    static int dx[] = {1, 0, -1, 0};
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            dfs(0, 0, 0);
           sb.append("#" + i).append("\n");
           print();
            cnt = 1;
        }
        System.out.println(sb);
    }

    static int cnt = 1;

    static void dfs(int y, int x, int dir) {
        map[y][x] = cnt++;
        if(cnt >(n)*(n))
            return;

        int ny = dy[dir] + y;
        int nx = dx[dir] + x;
        if (ny >= 0 && nx >= 0 && ny < n  && nx < n  && map[ny][nx] == 0) {
                dfs(ny, nx, dir);
        }
        else
        {
            dir = (dir + 1) % 4;
            ny = dy[dir] + y;
            nx = dx[dir] + x;
            dfs(ny, nx, dir);
        }

    }

    static void print() {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
               sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
    }

}

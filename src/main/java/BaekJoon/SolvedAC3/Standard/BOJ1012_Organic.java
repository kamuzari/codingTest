package BaekJoon.SolvedAC3.Standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_Organic {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int answer=0;
    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            v=new boolean[n][m];
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!v[i][j] && map[i][j]==1){
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
            answer=0;
        }
        System.out.println(sb);
    }
    static boolean v[][];
    static void dfs(int y,int x){
        v[y][x]=true;
        for (int i = 0; i < 4; i++) {
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(indexOutOf(ny,nx)) continue;
            if(v[ny][nx]) continue;
            if(map[ny][nx]==0)  continue;
            dfs(ny,nx);
        }
    }
    static boolean indexOutOf(int ny,int nx){
        return ny<0 || nx<0 || ny>n-1 || nx>m-1;
    }
}

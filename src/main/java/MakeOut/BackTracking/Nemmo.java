package MakeOut.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nemmo {

    private static int n;
    private static int m;
    private static boolean[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n+1][m+1];

        dfs(0);
        System.out.println(answer);
    }


    static void dfs(int cnt) {
        if(cnt == n * m) {
            answer ++;
            return ;
        }
        int y = cnt / m + 1;
        int x = cnt % m + 1;

        if(check(y,x)) { // 현재 놓을 수 없는 곳
            dfs(cnt + 1);
        }
        else {
            dfs(cnt + 1); // 선택 안하고 다음껄 볼 경우
            map[y][x] = true;
            dfs(cnt + 1); // 선택 하고 다음껄 볼 경우
            map[y][x] = false;
        }
    }


    private static boolean check(int i, int j) {
        return map[i-1][j] && map[i][j-1] && map[i-1][j-1];
    }


}

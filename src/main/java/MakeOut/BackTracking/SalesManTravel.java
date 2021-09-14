package MakeOut.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class SalesManTravel {
    static int route[][];
    private static int v;
    private static int min = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        route = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = 1; // 첫번쨰 방문
        dfs(0, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int start, int cur, int cost) {
        if ((v == (1 << n) - 1) && cost > 0 && route[cur][start]!=0) {
            min = Math.min(min, cost + route[cur][start]);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (route[cur][i] != 0) {
                if ((v & (1 << i)) == 0) {
                    v = v | (1 << i);
                    dfs(start, i, cost + route[cur][i]);
                    v = v & ~(1 << i);
                }
            }
        }
    }

}

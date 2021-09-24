package Basic.TreeDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1949_ExcellentVillage {
    static int dp[][];
    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            dp[i][1] = Integer.parseInt(st.nextToken());
        }
        list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        dfs(1, -1);
        System.out.println(Math.max(dp[1][0],dp[1][1]));
    }

    private static void dfs(int cur, int parent) {
        for (Integer next : list[cur]) {
            if (parent != next) {
                dfs(next,cur);
                dp[cur][0]+=Math.max(dp[next][0],dp[next][1]);
                dp[cur][1]+=dp[next][0];
            }
        }
    }
}

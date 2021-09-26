package Basic.TreeDP;

import java.util.*;

public class PGM72416_ProfitDecreaseMin {
    public static void main(String[] args) {
        int s[] = {14, 17, 15, 18, 19, 14, 13, 16, 28, 17};
        int l[][] = {
                {10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}
        };
        final PGM72416_ProfitDecreaseMin p = new PGM72416_ProfitDecreaseMin();
        final int solution = p.solution(s, l);
        System.out.println(solution);

    }

    int dp[][], salesArray[];
    List<Integer> list[];
    int n;

    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        n = sales.length;
        salesArray = sales;
        list = new List[n + 1];
        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        return Math.min(dp[1][0], dp[1][1]);
    }

    public int solve(int cur, int include) {
        if (dp[cur][include] != -1) {
            return dp[cur][include];
        }

        dp[cur][include] = 0;
        int ret = 0;

        if (include == 1) {
            for (Integer next : list[cur]) {
                ret += Math.min(solve(next, 1), solve(next, 0));
            }
            return dp[cur][include] = (ret + salesArray[cur - 1]);
        } else {
            boolean flag = false;
            int diff = (list[cur].size() > 0) ? (int) 1e9 : 0;
            for (Integer next : list[cur]) {
                int case1 = solve(next, 1);
                int case2 = solve(next, 0);
                if (case1 < case2) {
                    flag = true;
                } else {
                    diff = Math.min(case1 - case2, diff);
                }
                ret += Math.min(case1, case2);
            }
            return dp[cur][include] = (flag == true) ? ret : ret + diff;
        }
    }
}

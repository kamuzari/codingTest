package Basic.TreeDP;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2213_IndependentSetOfTree {
    static List<Integer> list[];
    static int dp[][];
    static boolean v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        dp = new int[n + 1][2];
        v = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new LinkedList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        travel(1);
        if (dp[1][0] > dp[1][1]) {
            System.out.println(dp[1][0]);
            pathTrack(1, false);
        } else  {
            System.out.println(dp[1][1]);
            pathTrack(1,true);
        }
        Collections.sort(path);
        for (Integer val : path) {
            System.out.print(val+" ");
        }
    }

    static void dfs(int cur, int parent) {
        for (Integer next : list[cur]) {
            if (parent != next) {
                dfs(next, cur);
                dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
                dp[cur][1] += dp[next][0];
            }
        }
    }

    static void travel(int cur) {
        v[cur] = true;

        for (Integer next : list[cur]) {
            if (!v[next]) {
                travel(next);
                if (dp[next][0] > dp[next][1]) {
                    dp[cur][0] += dp[next][0];
                } else if (dp[next][0] <= dp[next][1]) {
                    dp[cur][0] += dp[next][1];
                }
                dp[cur][1] += dp[next][0];
            }
        }

        v[cur] = false;
    }

    static List<Integer> path = new LinkedList<>();

    static void pathTrack(int cur, boolean attend) {
        v[cur] = true;
        if (attend) {
            path.add(cur);
            for (Integer next : list[cur]) {
                if (!v[next]) {
                    pathTrack(next, false);
                }
            }
        } else {
            for (Integer next : list[cur]) {
                if (!v[next]) {
                    if (dp[next][0] > dp[next][1]) {
                        pathTrack(next, false);
                    } else {
                        pathTrack(next, true);
                    }
                }
            }
        }
        v[cur] = false;
    }
}

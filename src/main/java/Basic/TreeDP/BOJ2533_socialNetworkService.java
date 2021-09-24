package Basic.TreeDP;

import java.util.*;
import java.io.*;

public class BOJ2533_socialNetworkService {
    public static LinkedList<Integer>[] adjList;
    public static boolean[] visited;
    public static int[][] dp;
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        adjList = new LinkedList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < N-1; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        dp(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    public static void dp(int cur, int parent) {
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for (Integer next : adjList[cur]) {
            if (next != parent) {
                dp(next, cur);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}

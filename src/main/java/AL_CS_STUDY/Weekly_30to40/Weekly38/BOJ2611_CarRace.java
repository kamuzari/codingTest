package AL_CS_STUDY.Weekly_30to40.Weekly38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2611_CarRace {
    private static int[] road;
    private static int[] dp;

    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }

    static List<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        road = new int[n + 2];
        dp = new int[n + 2];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (to == 1)
                to = n + 1;
            list[from].add(new Node(to, w));
        }
        Arrays.fill(dp,-1);
        dp[n+1]=0;
        System.out.println(recursion(1));
        int r=1;
        while (r<=n){
            System.out.print(r+" ");
            r=road[r];
        }
        System.out.printf("1\n");
    }

    private static int recursion(int vertex) {
        if(dp[vertex]!=-1)
            return dp[vertex];

        dp[vertex]=0;
        for (Node next : list[vertex]) {
            int weight= recursion(next.vertex)+next.weight;
            if(dp[vertex]<weight){
                dp[vertex]=weight;
                road[vertex]=next.vertex;
            }
        }
        return dp[vertex];
    }
}

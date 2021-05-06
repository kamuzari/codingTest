package tues_thurs_sat._20210506;

import java.util.Arrays;

public class GPS {
    public static void main(String[] args) {
        int a[][]=
                {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
        int b[]={1,2,3,3,6,7};
        System.out.println(solution(7,10,a,6,b));
    }
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int INF=(int)1e9;
        int road[][]=new int[n+1][n+1];
        for (int i = 0; i < edge_list.length; i++) {
            int a=edge_list[i][0];
            int b=edge_list[i][1];
            road[a][b]=1;
            road[b][a]=1;
        }
        int dp[][]=new int[k][n+1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i],INF);
        }
        dp[0][gps_log[0]]=0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]); //이동 x.
                for (int l = 1; l < n+1; l++) {
                    if(road[j][l]==1)
                    {
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][l]);
                    }
                }
                if(j!=gps_log[i])
                    dp[i][j]++;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        if(dp[k-1][gps_log[k-1]]<INF)
            return dp[k-1][gps_log[k-1]];
        return -1;
    }
}

package ProgrammersKit.DynamicProgramming;

import java.util.Arrays;

public class RoadToSchool {
    public static void main(String[] args) {
        int n=3;
        int m=4;
        int a[][]={{2,2}};
        System.out.println(solution(m,n,a));
    }
    public  static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int dp[][]=new int[n+1][m+1];
        dp[1][1]=1;
        for (int[] p : puddles) {
            dp[p[0]][p[1]]=-1;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(dp[i][j]==-1)
                    dp[i][j]=0;
                else
                    dp[i][j]+=(dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return answer;
    }
}

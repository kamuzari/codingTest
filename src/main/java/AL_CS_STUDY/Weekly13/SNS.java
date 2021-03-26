package AL_CS_STUDY.Weekly13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SNS {
   static int n;
   static int visited[];
   static int dp[][];
   static LinkedList<Integer> list[];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        visited=new int[n+1];
        dp=new int[n+1][2];
        list=new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i]=new LinkedList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    static void dfs(int idx)
    {
        visited[idx]=1;
        dp[idx][0]=0; // 얼리어답터가 아닌경우
        dp[idx][1]=1; // 얼리어 답터 인 경우.

        List<Integer> item=list[idx];
        for (Integer to : item) {
            if(visited[to]==0)
            {
                dfs(to);
                dp[idx][0]+=dp[to][1];
                dp[idx][1]+=Math.min(dp[to][0],dp[to][1]);
            }
        }

    }
}

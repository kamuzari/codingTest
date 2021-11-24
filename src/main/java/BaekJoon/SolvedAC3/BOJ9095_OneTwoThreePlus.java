package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1,2,3 만 사용한다.
dp[n] 을 n을 만드는 경우의 수
 ** 1,2,3만을 사용해야 하므로 n을 만드는 경우의 수 라하면 n -1 ,n-2 ,n-3 말은
 즉, n-1을 만드는 경우의 수에는 1이 필요하다. n-2를 만드는 경우의 수에도 숫자 2가 필요하다는 말과 같음
 그러므로 dp[n]=dp[n-1] + dp[n-2] +dp[n-3] => n을 만드는 경우의수 = 1이 필요한 경우의 수 + 2가 필요한 경우의 수수 + 3이 필요한 경우의 수

*/
public class BOJ9095_OneTwoThreePlus {
    static int arr[]={1,2,3};
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answers=new StringBuilder();
        int testCase=Integer.parseInt(br.readLine());
        while (testCase-->0){
            int n=Integer.parseInt(br.readLine());
            dynamic(n,answers);
           /* pick(0,0,n);
            answers.append(answer).append("\n");
            answer=0;*/
        }
        System.out.println(answers);

    }
    static void pick(int cnt,int sum,int target){
        if(sum==target){
            answer++;
            return;
        }
        for (int i = 0; i <3; i++) {
            if(sum+arr[i]>target) continue;
            pick(cnt+1,sum+arr[i],target);
        }
    }
    static void dynamic(int n,StringBuilder answers){
        long dp[]=new long[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        answers.append(dp[n]+"\n");
    }
}

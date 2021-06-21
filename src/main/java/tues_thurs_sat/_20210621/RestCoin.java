package tues_thurs_sat._20210621;

public class RestCoin {
    public static void main(String[] args) {
        System.out.println(solution(5,new int[]{1,2,5}));
    }
    public static int solution(int n, int[] money) {
        int answer = 0;
        int dp[]=new int[n+1];
        dp[0]=1;
        for (int i = 0; i <money.length ; i++) {
            for (int j = money[i]; j < n+1; j++) {
                dp[j]=dp[j]+dp[j-money[i]];
            }
        }
        answer=dp[n];
        return answer;
    }
}

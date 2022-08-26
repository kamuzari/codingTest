package programmers.lv2;

public class Fibonacci {

    int dp[];

    public int solution(int n) {
        dp = new int[n + 1];
        return fibo(n);
    }

    public int fibo(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n] % 1234567;
        }
        return dp[n] = (fibo(n - 2) + fibo(n - 1)) % 1234567;
    }
}

public class Test2 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(solution(9));
        System.out.println(solution(15));
        System.out.println(solution(100000));
        System.out.println(solution(41));
    }


    static int cnt = 0;
    static int min = Integer.MAX_VALUE;
    static int len = 0;

    public static int solution2(int n) {
        int answer = 0;
        return answer;
    }
    static int nemo[]=new int[333];
    static int dp[]=new int[100001];
    public static int solution(int n) {
        int answer = 0;
        len = n;
        for (int i = 1; i <= n; i++) dp[i] = 987654321;

        dp[0] = 0;
        for (int i = 1; i <= 320; i++)
            nemo[i] = i * i;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 316; j++) {
                if (i - nemo[j] < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - nemo[j]] + 1);
            }
        }

//        System.out.println(dp[n]);
//        check(n);
        return dp[n];
    }

    public static void check(int n) {
        if (n == 0) {
            min = Math.min(min, cnt);
            cnt--;
            return;
        }
        for (int i = 1; i <= len; i++) {
            int pow = (int) Math.pow(i, 2);
            if (n - pow >= 0) {
                cnt++;
                check(n - pow);
            } else {
                cnt--;
                return;
            }
        }
    }
}

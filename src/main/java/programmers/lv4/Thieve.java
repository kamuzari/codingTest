package programmers.lv4;

public class Thieve {
	/**
	 첫번째 집을 털고 시작, 첫번째 집을 털지 않고 시작 두가지 경우
	 */
	public int solution(int[] money) {
		int answer = 0;
		int n = money.length;
		int dp[] = new int[n]; // 첫번쨰 집 털고 시작
		int dp2[] = new int[n];// 첫번째 집 안털고 시작
		dp[0] = money[0];
		dp[1] = money[0]; // 첫번째 집을 무조건 털었으니 money[1]은 자동으로 못턴다! 그러므로 money[1]이 아닌 money[0] 이여야 한다.

		for (int i = 2; i < money.length - 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
		}

		dp2[1] = money[1];
		for (int i = 2; i < money.length; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
		}

		return Math.max(dp[n - 2], dp2[n - 1]);
	}
}

package programmers.lv2;

public class FarJump {
	private static final int FIX_MODULAR = 1234567;
	private static final int MAX_CAPACITY = 2001;

	public long solution(int n) {

		int target[] = new int[MAX_CAPACITY];

		target[1] = 1;
		target[2] = 2;

		for (int i = 3; i <= n; i++) {
			target[i] = (target[i - 2] + target[i - 1]) % FIX_MODULAR;
		}

		return target[n];
	}
}

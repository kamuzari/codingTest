package programmers.mockquestions.bundle31;

public class BinaryTranlationRepeat {
	static final String TARGET = "1";

	public int[] solution(String s) {
		int turn = 0;
		int zero = 0;

		while (!s.equals(TARGET)) {
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (ch == '0') {
					zero++;
					continue;
				}

				cnt++;
			}

			s = Integer.toBinaryString(cnt);
			turn++;
		}

		return new int[] {turn, zero};
	}
}

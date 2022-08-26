package programmers.mockquestions.bundle1;

public class MinimumRectangle {
	public int solution(int[][] sizes) {
		int maxHorizon = 0;
		int maxVertical = 0;

		for (int i = 0; i < sizes.length; i++) {
			int vertical = Math.max(sizes[i][0], sizes[i][1]);
			int horizon = Math.min(sizes[i][0], sizes[i][1]);

			maxVertical = Math.max(vertical, maxVertical);
			maxHorizon = Math.max(horizon, maxHorizon);
		}

		return maxHorizon * maxVertical;
	}
}

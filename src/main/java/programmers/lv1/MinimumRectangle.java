package programmers.lv1;

public class MinimumRectangle {
	public static void main(String[] args) {

	}

	/**
	 * note : n * 2 번 loop 최적화 -> n * 1번의 loop
	 * @param sizes
	 * @return
	 */
	public int solutionOptimize(int[][] sizes) {
		int maxRow = 0;
		int maxCol = 0;

		for (int[] card : sizes) {
			maxRow = Math.max(maxRow, Math.max(card[0], card[1]));
			maxCol = Math.max(maxCol, Math.min(card[0], card[1]));
		}

		return maxRow * maxCol;
	}

	/**
	 note : 첫번째 풀이
	 - 한쪽을 큰 값으로 셋팅 후 -> 다른 한쪽 중 큰 값을 탐색함.
	 hint : 한쪽 (가로, 세로 중 택 1)을 가장 큰 값으로 몰아넣기!
	 */
	public int solution(int[][] sizes) {
		int maxRow = 0;

		for (int i = 0; i < sizes.length; i++) {
			int row = sizes[i][0];
			int col = sizes[i][1];

			if (row < col) {
				sizes[i][0] = col;
				sizes[i][1] = row;
			}

			maxRow = Math.max(maxRow, sizes[i][0]);
		}

		int maxCol = 0;

		for (int i = 0; i < sizes.length; i++) {
			int col = sizes[i][1];

			maxCol = Math.max(maxCol, col);
		}

		return maxRow * maxCol;
	}
}

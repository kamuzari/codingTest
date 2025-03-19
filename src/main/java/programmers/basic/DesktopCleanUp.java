package programmers.basic;

public class DesktopCleanUp {
	// 가장 왼쪽에 있는 열, 가장 오른쪽에 있는열, 가장 위쪽에 있는행, 가장 아래쪽에있는 행
	// 찾고 {가장 위쪽에 있는 행, 가장 왼쪽에 있는 열, 가장 아래쪽에 있는 행, 가장 오른쪽에 있는 열}
	public int[] solution(String[] wallpaper) {

		int n = wallpaper.length;
		int m = wallpaper[0].length();

		int topRow = n;
		int bottomRow = 0;
		int leftCol = m;
		int rightCol = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				String block = wallpaper[i].charAt(j) + "";
				if (block.equals("#")) {
					topRow = Math.min(topRow, i);
					bottomRow = Math.max(bottomRow, i);
					leftCol = Math.min(leftCol, j);
					rightCol = Math.max(rightCol, j);
				}
			}
		}

		return new int[] {topRow, leftCol, bottomRow + 1, rightCol + 1};
	}
}

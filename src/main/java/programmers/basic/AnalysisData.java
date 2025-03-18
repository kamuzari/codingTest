package programmers.basic;

import java.util.Arrays;

public class AnalysisData {
	enum Colums {
		CODE("code", 0),
		DATE("date", 1),
		MAXIMUM("maximum", 2),
		REMAIL("remain", 3);

		private String name;
		private int index;

		private Colums(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public static Colums of(String name) {
			return Arrays.stream(Colums.values())
				.filter(col -> col.name.equals(name))
				.findAny()
				.orElseThrow(RuntimeException::new);
		}
	}

	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		final int filterIndex = Colums.of(ext).index;
		final int sortIndex = Colums.of(sort_by).index;
		return Arrays.stream(data)
			.filter(d -> d[filterIndex] < val_ext)
			.sorted((a, b) -> a[sortIndex] - b[sortIndex])
			.toArray(int[][]::new);
	}
}

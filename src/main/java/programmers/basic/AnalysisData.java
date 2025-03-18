package programmers.basic;

import java.util.Arrays;
import java.util.List;

public class AnalysisData {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		List<String> cols = Arrays.asList("code", "date", "maximum", "remain");
		int filterIndex = cols.indexOf(ext);
		int sortIndex = cols.indexOf(sort_by);
		return Arrays.stream(data)
			.filter(d -> d[filterIndex] < val_ext)
			.sorted((a, b) -> a[sortIndex] - b[sortIndex])
			.toArray(int[][]::new);
	}
}

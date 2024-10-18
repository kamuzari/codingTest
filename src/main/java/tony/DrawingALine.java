package tony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DrawingALine {
	static class Line {
		private int start;
		private int end;

		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public static Comparator<Line> getDefaultOrder() {
			Comparator<Line> startAscAndEndAsc = (a, b) -> {
				if (a.start == b.start) {
					return a.end - b.end;
				}

				return a.start - b.start;
			};

			return startAscAndEndAsc;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Line> lines = new ArrayList<>();
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			lines.add(new Line(s, e));
		}
		Collections.sort(lines, Line.getDefaultOrder());

		int s = -1;
		int e = -1;
		int answer = 0;
		for (Line next : lines) {
			boolean isInitial = s == -1 && e == -1;
			if (isInitial) {
				s = next.start;
				e = next.end;
			} else {
				boolean isOverlap = e >= next.start;
				if (isOverlap) {
					e = Math.max(e, next.end);
				} else {
					answer += (e - s);
					s = next.start;
					e = next.end;
				}
			}
		}

		answer += e - s;
		System.out.println(answer);
	}
}

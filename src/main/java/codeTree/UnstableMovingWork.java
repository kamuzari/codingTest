package codeTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UnstableMovingWork {
	/**
	 무빙워크 := queue
	 n: 200,000
	 안정성: 1000
	 */
	static class Input {
		int n;
		int k;
		List<Integer> movingWork;

		public Input(int n, int k, List<Integer> movingWork) {
			this.n = n;
			this.k = k;
			this.movingWork = movingWork;
		}
	}

	static class Rail {
		int stable;
		boolean isExist;

		public Rail(int stable, boolean isExist) {
			this.stable = stable;
			this.isExist = isExist;
		}

	}

	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Input input = request(new Scanner(System.in));
		LinkedList<Rail> rails = new LinkedList<>();
		input.movingWork.stream().map(v -> new Rail(v, false)).forEach(rails::add);
		int limit = input.k;
		int downIndex = input.n;
		int testCase = 1;
		while (limit > 0) {
			rails.offerFirst(rails.pollLast());
			// 내린사람 지워주기
			Rail rail = rails.get(input.n);
			if (rail.isExist) {
				rail.isExist = false;
			}

			for (int i = input.n - 1; i >= 0; i--) {
				Rail cur = rails.get(i);
				int next = i + 1;

				if (!cur.isExist)
					continue;

				if (next == input.n) {
					cur.isExist = false;
					continue;
				}

				Rail nextRail = rails.get(next);
				if (nextRail.isExist || nextRail.stable == 0) {
					continue;
				}

				nextRail.isExist = true;
				nextRail.stable = nextRail.stable - 1;
				cur.isExist = false;
				if (nextRail.stable == 0) {
					limit--;
				}
			}

			Rail first = rails.get(0);
			if (!first.isExist && first.stable > 0) {
				first.isExist = true;
				first.stable = first.stable - 1;
				if (first.stable == 0) {
					limit--;
				}
			}

			if (limit <= 0) {
				break;
			}

			testCase++;
		}

		System.out.println(testCase);
	}

	static Input request(Scanner sc) {
		String str[] = sc.nextLine().split(" ");
		List<Integer> list = new ArrayList<>();
		String str2[] = sc.nextLine().split(" ");
		for (int i = 0; i < str2.length; i++) {
			list.add(Integer.parseInt(str2[i]));
		}

		return new Input(
			Integer.parseInt(str[0]),
			Integer.parseInt(str[1]),
			list
		);
	}
}
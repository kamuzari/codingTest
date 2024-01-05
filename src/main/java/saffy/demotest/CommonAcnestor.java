package saffy.demotest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class CommonAcnestor {
	static List<Integer> upperBranches[];
	static List<Integer> downBranches[];
	static Set<Integer> aParents = new HashSet<>();
	static int commonAncestor = 0;
	static int commonAncestorSize = 0;
	static boolean isFoundCommonAncestor = false;

	public static void main(String[] args) {
		StringBuilder answers = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int repeatCount = Integer.parseInt(sc.nextLine());

		for (int testCase = 1; testCase <= repeatCount; testCase++) {
			isFoundCommonAncestor = false;
			aParents.clear();
			commonAncestorSize = 0;
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = Integer.parseInt(st.nextToken());
			upperBranches = new List[n + 1];
			downBranches = new List[n + 1];
			for (int i = 1; i <= n; i++) {
				upperBranches[i] = new ArrayList<>();
				downBranches[i] = new ArrayList<>();
			}
			int e = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < e; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				upperBranches[child].add(parent); // 자식에서 부모로 가게한다.
				downBranches[parent].add(child);
			}

			searchParents(a);
			int root = -1;
			if (aParents.contains(b)) {
				root = b;
			} else {
				compare(b);
			}

			calculateSize(commonAncestor);
			String answer = String.format("#%d %d %d", testCase, commonAncestor, commonAncestorSize);
			answers.append(answer).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	private static void calculateSize(int cur) {
		commonAncestorSize++;
		for (Integer child : downBranches[cur]) {
			calculateSize(child);
		}
	}

	private static void compare(int cur) {
		if (isFoundCommonAncestor) {
			return;
		}

		for (Integer bParent : upperBranches[cur]) {
			if (aParents.contains(bParent)) {
				isFoundCommonAncestor = true;
				commonAncestor = bParent;
				return;
			}

			compare(bParent);
		}
	}

	private static void searchParents(int cur) {
		aParents.add(cur);
		for (Integer parent : upperBranches[cur]) {
			searchParents(parent);
		}
	}
}

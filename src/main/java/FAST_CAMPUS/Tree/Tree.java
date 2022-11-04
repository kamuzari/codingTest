package FAST_CAMPUS.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree {

	private static List<Integer>[] parents;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());

		StringTokenizer st = new StringTokenizer(reader.readLine());

		parents = new List[n];

		for (int i = 0; i < n; i++) {
			parents[i] = new ArrayList<>();
		}

		int root = -1;

		for (int node = 0; node < n; node++) {
			int parent = Integer.parseInt(st.nextToken());

			if (parent == -1) {
				root = node;
				continue;
			}

			parents[parent].add(node);
		}

		int deletingNode = Integer.parseInt(reader.readLine());

		if (deletingNode != root) {
			delete(root, deletingNode);
			searchLeaf(root);
		}

		System.out.println(answer);
	}

	public static void delete(int parent, int deletingNode) {
		for (int i = 0; i < parents[parent].size(); i++) {
			Integer next = parents[parent].get(i);

			if (next == deletingNode) {
				parents[parent].remove(i);
				i--;
			} else {
				delete(next, deletingNode);
			}
		}
	}

	public static void searchLeaf(int parent) {
		if (parents[parent].isEmpty()) {
			answer++;
			return;
		}

		for (Integer next : parents[parent]) {
			searchLeaf(next);
		}
	}

}

package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Friend {

	private static int[] relations;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		relations = new int[n+1];

		for (int i = 1; i <= n; i++) {
			relations[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(reader.readLine());
			int friendA = Integer.parseInt(st.nextToken());
			int friendB = Integer.parseInt(st.nextToken());
			union(friendA, friendB);
		}

		st = new StringTokenizer(reader.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(find(A) == find(B) ? "YES" : "NO");
	}

	public static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);

		if (root1 > root2) {
			relations[root1] = root2;
		} else {
			relations[root2] = root1;
		}
	}

	public static int find(int a) {
		if (relations[a] == a)
			return a;

		return find(relations[a]);
	}
}

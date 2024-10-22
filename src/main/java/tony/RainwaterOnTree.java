package tony;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RainwaterOnTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		List<Integer> bridges[] = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			bridges[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(sc.nextLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bridges[u].add(v);
			bridges[v].add(u);
		}

		int terminalNodeCount = 0;
		// todo: 1번은 빼야함.
		for (int i = 2; i <= n; i++) {
			boolean isTerminalNode = bridges[i].size() == 1;
			if (isTerminalNode) {
				terminalNodeCount++;
			}
		}

		System.out.println(String.format("%.10f", (double)w / terminalNodeCount));
	}

}

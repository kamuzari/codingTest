package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumProfit {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int profits[] = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i <n; i++) {
			profits[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int maxProfit = 0;

		int sum = 0;
		while (true) {

			if (end > n - 1) {
				break;
			}

			if (end - start < k) {
				sum += profits[end++];
			} else if (end - start > k) {
				sum -= profits[start++];
				maxProfit = Math.max(maxProfit, sum);
			}

			if(end- start == k){
				maxProfit = Math.max(maxProfit, sum);
				sum -= profits[start++];
			}
		}

		System.out.println(maxProfit);
	}
}

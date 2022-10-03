package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MisCheif {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
		int[] orders = new int[n];

		for (int i = 0; i < n; i++) {
			orders[i] = Integer.parseInt(st.nextToken());
		}

		int[] originals = orders.clone();
		Arrays.sort(orders);

		List<Integer> answers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (originals[i] != orders[i]) {
				answers.add(i+1);
			}
		}

		String answer = answers.stream().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(answer);
	}

}
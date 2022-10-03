package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LeastRecentlyUsed {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int cacheSize = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int tasks[] = new int[n];
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			tasks[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> cache = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int task = tasks[i];

			if (cache.contains(task)) {
				cache.remove((Integer)task);
			}

			cache.addFirst(task);

			if (cacheSize < cache.size()) {
				cache.pollLast();
			}
		}

		String answer = cache.stream().map(String::valueOf).collect(Collectors.joining(" "));

		System.out.println(answer);
	}
}
/**
 * note: remove() 주의 -> 객체 형태 Integer이면 해당 객체와 같은 것을 지우고,
 *   int형이면 인덱스로 접근하여 지운다. 여기에서 int형으로 객체를 지우게 하다가 한꺼번에 지워졌다.
3 5
1 1 1 1 1
 */
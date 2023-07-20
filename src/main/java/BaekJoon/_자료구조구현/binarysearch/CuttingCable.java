package BaekJoon._자료구조구현.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingCable {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(st.nextToken());
		int requirementCable = Integer.parseInt(st.nextToken());

		int[] cables = new int[k];
		for (int i = 0; i < k; i++) {
			cables[i] = Integer.parseInt(reader.readLine());
		}

		long answer = getCableMaximumLength(cables, requirementCable);
		System.out.println(answer);
	}

	private static long getCableMaximumLength(int[] cables, int requirementCable) {
		long maxValue = 0;
		long start = 1;
		long end = Integer.MAX_VALUE;

		while (start <= end) {
			long mid = (start + end) >> 1;
			long count = cut(cables, mid);

			if (count >= requirementCable) {
				// 요구사항보다 더 많이 자르면 더 큰 단위로 잘르기
				maxValue = Math.max(mid, maxValue);
				start = mid + 1;
			} else {
				// 요구사항을 만족시키지 못하면더 더 작은 단위로 잘르기
				end = mid - 1;
			}
		}

		return maxValue;
	}

	private static long cut(int[] cables, long unit) {
		long count = 0;
		for (int i = 0; i < cables.length; i++) {
			count += cables[i] / unit;
		}

		return count;
	}
}
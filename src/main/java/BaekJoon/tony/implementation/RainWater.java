package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RainWater {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] heights = new int[m];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int rainBucket = 0;
		for (int pivot = 1; pivot < m - 1; pivot++) {

			int pivotValue = heights[pivot];
			int leftMaxHeight = 0;
			for (int i = 0; i < pivot; i++) {
				leftMaxHeight = Math.max(leftMaxHeight, heights[i]);
			}

			int rightMaxHeight = 0;
			for (int i = pivot + 1; i < m; i++) {
				rightMaxHeight = Math.max(rightMaxHeight, heights[i]);
			}

			if (leftMaxHeight > pivotValue && rightMaxHeight > pivotValue) {
				rainBucket += Math.min(leftMaxHeight, rightMaxHeight) - pivotValue;
			}
		}

		System.out.println(rainBucket);
	}

}

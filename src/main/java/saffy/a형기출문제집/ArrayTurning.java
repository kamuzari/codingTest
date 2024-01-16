package saffy.a형기출문제집;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ArrayTurning {
	private static int n;
	private static int m;
	private static int k;
	private static int[][] arr;
	private static List<int[]> rotateOperators;
	private static int[] rotateOperatorOrders;
	private static Set<Integer> pickedRotateOperatorIdentifications;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		requestInput();
		determineOrder(0);
		System.out.println(answer);
	}

	private static void determineOrder(int depth) {
		if (depth == k) {
			List<int[]> orderedRotateOperators = Arrays.stream(rotateOperatorOrders)
					.mapToObj(rotateOperatorId -> rotateOperators.get(rotateOperatorId))
					.collect(Collectors.toList());
			int minimumRowSummaryValue = turn(orderedRotateOperators);
			answer = Math.min(answer, minimumRowSummaryValue);
			return;
		}

		for (int rotateOperatorId = 0; rotateOperatorId < k; rotateOperatorId++) {
			if (pickedRotateOperatorIdentifications.contains(rotateOperatorId)) {
				continue;
			}

			rotateOperatorOrders[rotateOperatorId] = depth;
			pickedRotateOperatorIdentifications.add(rotateOperatorId);
			determineOrder(depth + 1);
			pickedRotateOperatorIdentifications.remove(rotateOperatorId);
		}
	}

	private static class Node {
		private int y;
		private int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

	private static int turn(List<int[]> orderedRotateOperators) {
		int minimumRowSummary = Integer.MAX_VALUE;
		int copies[][] = copyArray();
		for (int[] operator : orderedRotateOperators) {
			int y = operator[0];
			int x = operator[1];
			int optionValue = operator[2];
			Node leftTop = new Node(y - optionValue - 1, x - optionValue - 1); // rightBottom 보다 y,x 다 작아야한다.
			Node rightBottom = new Node(y + optionValue - 1, x + optionValue - 1);

			while (isPossibleRotate(leftTop, rightBottom)) {
				rotate(leftTop, rightBottom, copies);
				Node newLeftTop = new Node(leftTop.y + 1, leftTop.x + 1);
				Node newRightBottom = new Node(rightBottom.y - 1, rightBottom.x - 1);
				leftTop = newLeftTop;
				rightBottom = newRightBottom;
			}

		}
		for (int i = 0; i < n; i++) {
			int rowSummary = Arrays.stream(copies[i]).sum();
			minimumRowSummary = Math.min(rowSummary, minimumRowSummary);
		}

		return minimumRowSummary;
	}

	private static int[][] copyArray() {
		int copies[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			copies[i] = arr[i].clone();
		}

		return copies;
	}

	private static boolean isPossibleRotate(Node leftTop, Node rightBottom) {
		return leftTop.y < rightBottom.y && leftTop.x < rightBottom.x;
	}

	private static void rotate(Node leftTop, Node rightBottom, int[][] copies) {
		int leftTopValue = copies[leftTop.y][leftTop.x];

		for (int i = leftTop.y; i < rightBottom.y; i++) {
			copies[i][leftTop.x] = copies[i + 1][leftTop.x];
		}

		for (int i = leftTop.x; i < rightBottom.x; i++) {
			copies[rightBottom.y][i] = copies[rightBottom.y][i + 1];
		}

		for (int i = rightBottom.y; i > leftTop.y; i--) {
			copies[i][rightBottom.x] = copies[i - 1][rightBottom.x];
		}

		for (int i = rightBottom.x; i > leftTop.x; i--) {
			copies[leftTop.y][i] = copies[leftTop.y][i - 1];
		}

		copies[leftTop.y][leftTop.x + 1] = leftTopValue;
	}

	private static void requestInput() {
		Scanner sc = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotateOperatorOrders = new int[k];
		rotateOperators = new ArrayList<>();
		pickedRotateOperatorIdentifications = new HashSet<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(sc.nextLine());
			rotateOperators.add(new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
			});
		}
	}
}

package BaekJoon.tony.greedy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class HoneyPicking {

	public static void main(String[] args) {
		Reader reader = new Reader();
		int n = reader.n;
		int[] honies = reader.arr;

		// 어떻게 하면 최대 꿀을 딸 수 있을까?
		// - 조합 완전 탐색 x -> 시간초과
		// 누적합도 아니고.. -> 최적의 경우를 뽑아내는게 힘들었네..
		int rightSum[] = new int[n];
		int leftSum[] = new int[n];

		rightSum[0] = honies[0];
		leftSum[n - 1] = honies[n - 1];

		for (int i = 1; i < n; i++) {
			rightSum[i] = rightSum[i - 1] + honies[i];
		}

		for (int i = n - 2; i >= 0; i--) {
			leftSum[i] = leftSum[i + 1] + honies[i];
		}

		int answer = 0;

		// 꿀벌 1 -> [꿀벌1 위치 +1, 벌통위치]
		int bee1Total = (rightSum[n - 1] - honies[0]);

		//1.벌통 오른쪽 고정 , 꿀벌 1 한마리 왼쪽 고정
		for (int i = 1; i < n - 1; i++) {
			int bee1 = bee1Total - honies[i];
			int bee2 = leftSum[i] - honies[i];

			answer = Math.max(answer, bee1 + bee2);
		}

		// 꿀벌 1 -> [꿀벌1 위치 -1, 0]
		bee1Total = (leftSum[0] - honies[n - 1]);

		//2. 벌통 왼쪽 고정, 꿀벌1 한마리 오른쪽 고정
		for (int i = 1; i < n - 1; i++) {
			int bee1 = bee1Total - honies[i];
			int bee2 = rightSum[i] - honies[i];

			answer = Math.max(answer, bee1 + bee2);
		}

		//3. 왼쪽,오른쪽 벌 1,2, 고정 벌통 이동
		for (int i = 1; i < n - 1; i++) {
			int bee1 = rightSum[i] - honies[0];
			int bee2 = leftSum[i] - honies[n - 1];

			answer = Math.max(answer, bee1 + bee2);
		}

		print(String.valueOf(answer));
	}

	public static void print(String s) {
		System.out.println(s);
	}

	static class Reader {
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr;

		public Reader() {
			n = parse(sc.nextLine());

			arr = new int[n];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < n; i++) {
				arr[i] = parse(st.nextToken());
			}
		}

		public static int parse(String s) {
			return Integer.parseInt(s);
		}

	}
}

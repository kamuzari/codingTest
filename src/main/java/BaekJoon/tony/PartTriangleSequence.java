package BaekJoon.tony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PartTriangleSequence {
	/**
	 * 수열 n개가 주어진다. b[i], b[j],b[k]인 수열을 삼각 수열이라고 한다.
	 * x, y, z가 x+y>z, x+z>y, y+z>x의 관계를 만족하면, 세 수는 삼각관계에 있다고 한다.
	 * 삼각 수열의 최대 길이를 구하라.
	 *  - i,j,k는 모두 다른 값이면 : 서로 다른 수임 (같은 값일 수는 있다.인덱스만 다른것)
	 *
	 * note
	 *  n= 3, arr[]={1,2,3} -> 2 가 나오는 과정이 안그려짐
	 *  n= 1, arr[]={100_000_000} -> 1이 나오는 과정이 안그려짐.
	 *  적절히 원소를 추출해서 삼각 수열을 만들려고 한다.
	 *
	 *  내가 생각한 흐름: n개의 수에서 3개 뽑기(순열)
	 *
	 *  문재 해석:
	 *   - 세수가 x+y>z, x+z>y, y+z>x 관게를 만족하는 부분 수열의 최대 길이를 구하라.
	 *   세수가 저런 관계를 만족한다면 ?
	 *   ->정렬 (위치는 상관없다.) -> 정렬 하라는 말이 없지 어떻게 알았을까?
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int maxLength = Math.min(n, 2);

		for (int first = 0; first < n - 1; first++) {
			for (int third = n - 1; third >= 0; third--) {
				if (first + 1 == third) // 서로 다른 세 수가 아니다! (조건 만족 x)
					break;

				int firstNext = first + 1;
				if (arr[first] + arr[firstNext] > arr[third]) { // 삼각 수열을 만족한다면
					maxLength = Math.max(maxLength, third - first + 1);
					break; // 왜 =: 어차피 최대 길이를 구하므로 전에는 어차피 짧다.
				}
			}
		}

		System.out.println(maxLength);
	}
}

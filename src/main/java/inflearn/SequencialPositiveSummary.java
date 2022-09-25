package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequencialPositiveSummary {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());
		int target = Integer.parseInt(st.nextToken());
		int arr[] = new int[target];

		for (int i = 1; i < target; i++) {
			arr[i] = i;
		}

		int start = 1;
		int end = 1;
		int sum = 0;
		int answer=0;

		while (true) {
			if (end > target - 1) {
				break;
			}

			if(sum < target){
				sum+=arr[end++];
			}else if(sum >target){
				sum-=arr[start++];
			}

			if(sum==target){
				answer++;
				sum-=arr[start++];
			}
		}

		System.out.println(answer);

		SequencialPositiveSummary sequencialPositiveSummary = new SequencialPositiveSummary();
		int solution = sequencialPositiveSummary.solution(15);
		System.out.println(solution);
	}

	/**
	 * note : 수학적 풀이
	 *
	 */
	public int solution(int n){
		int answer=0;
		int cnt=1;

		n-=cnt;

		while (n>0){
			cnt++;
			n-=cnt;
			if(n%cnt==0) answer++;
		}

		return answer;
	}
}

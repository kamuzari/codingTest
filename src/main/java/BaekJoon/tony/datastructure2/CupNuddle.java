package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CupNuddle {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int arr[][]=new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0]=a;
			arr[i][1]=b;
		}

		System.out.println(solution(n,arr));
	}

	static int solution(int n,int arr[][]){
		int answer=0;
		int maxDeadLine=0;

		for(int[] a: arr){
			maxDeadLine=Math.max(maxDeadLine,a[0]);
		}

		List<Integer> problems[]=new List[maxDeadLine+1]; // 마감기한 별 숙제들
		for(int i=1; i<=maxDeadLine; i++){
			problems[i]=new ArrayList<>();
		}

		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

		for(int[] a: arr){
			int deadLine=a[0];
			problems[deadLine].add(a[1]);
		}

		int time = maxDeadLine;

		while(time>0){
			pq.addAll(problems[time]);
			if(!pq.isEmpty()){
				answer+=pq.poll();
			}

			time--;
		}


		return answer;
	}
}

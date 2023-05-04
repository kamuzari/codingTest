package BaekJoon.tony.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class RailRoad {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
		}

		int d = Integer.parseInt(reader.readLine());

		System.out.println(solution(n, arr, d));
	}

	static class Person implements Comparable<Person>{
		int start, end;
		public Person(int start,int end){
			// 입력이 반대로 들어올 수도 있음.
			if(start>end){
				this.start=end;
				this.end=start;
			}else{
				this.start=start;
				this.end=end;
			}

		}

		@Override
		public int compareTo(Person o){
			return this.start - o.start;
		}

		public Person copy(){
			return new Person(this.start,this.end);
		}

	}
	static int solution(int n,int[][] arr,int d){
		int answer=0;

		List<Person> persons=Arrays.stream(arr).map(a-> new Person(a[0],a[1]))
			.sorted((a,b)-> {
				if(a.end == b.end){
					return a.start- b.start;
				}

				return a.end-b.end;
			}).collect(Collectors.toList());


		PriorityQueue<Person> pq=new PriorityQueue<>();

		for(Person p : persons){
			pq.offer(p.copy());
			int start=p.end - d;

			while(!pq.isEmpty()){
				if(pq.peek().start<start){
					pq.poll();
				}else{
					break;
				}
			}

			answer=Math.max(answer,pq.size());
		}
		return answer;
	}
}

package codeTree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class 조삼모사 {
	static Scanner sc =new Scanner(System.in);
	static StringTokenizer st;

	static int mornings[];
	static int n,answer =Integer.MAX_VALUE;
	static Set<Integer> a=new HashSet<>();
	static int works[][];
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		n=parse(line());
		mornings=new int[n/2];
		works=new int[n][n];
		Set<Integer> total = new HashSet();
		for(int i=0; i<n; i++){
			st=token();
			for(int j=0; j<n; j++){
				works[i][j]=parse(next());
			}
			total.add(i);
			// print(Arrays.(works[i]));
		}

		pick(0,0,n/2);
		print(String.valueOf(answer));
	}

	static void pick(int cnt,int idx,int target){
		if(cnt == target){
			// 계산

			Set<Integer> b=new HashSet<>();
			for(int i=0; i<n; i++){
				if(a.contains(i)) continue;
				b.add(i);
			}

			int A=calculate(a);
			int B=calculate(b);
			answer=Math.min(Math.abs(A-B),answer);

			return;
		}

		for(int i=idx; i<n; i++){
			a.add(i);
			pick(cnt+1,i+1,target);
			a.remove(i);
		}
	}

	static int calculate(Set<Integer> a){
		int[] arr=a.stream().mapToInt(val -> val).toArray();
		int answer=0;
		for(int i=0; i<arr.length; i++){
			int r=arr[i];
			for(int j=i+1; j<arr.length; j++){
				int c=arr[j];
				answer+=(works[r][c]+works[c][r]);
			}
		}

		return answer;
	}

	static void print(String s){
		System.out.println(s);
	}

	static String line(){
		return sc.nextLine();
	}

	static StringTokenizer token(){
		return new StringTokenizer(line());
	}

	static String next(){
		return st.nextToken();
	}

	static int parse(String s){
		return Integer.parseInt(s);
	}
}

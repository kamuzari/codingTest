package codeTree;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxmizeOutSourcingProfits {
	// 최대한 많은 일을 해도, 연속적으로 일을 해도 최대 수익을 보장할 수 없다.
	// 그러니 dp를...
	static Scanner sc=new Scanner(System.in);
	static class Work{
		private int processTime,profit;

		public Work(int processTime, int profit){
			this.processTime=processTime;
			this.profit=profit;
		}
	}
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		int n=parseInt(input());
		Work[] works=new Work[n];

		for(int i=0; i<n; i++){
			StringTokenizer st=new StringTokenizer(input());

			int processTime=parseInt(st.nextToken());
			int profit=parseInt(st.nextToken());

			works[i]=new Work(processTime, profit);
		}


		// 뒤에 부터 완성시켜나가기 : 퇴사 문제와 똑같음.
		int[] dp=new int[n+1];
		for(int i=n-1; i>=0; i--){
			int nextDay=i+works[i].processTime;
			if(nextDay>n){
				dp[i]=dp[i+1];
				continue;
			}

			dp[i]=Math.max(dp[i+1],dp[nextDay]+works[i].profit);
		}

		System.out.println(dp[0]);
	}

	public static String input(){
		return sc.nextLine();
	}

	public static int parseInt(String s){
		return Integer.parseInt(s);
	}
}

package programmers.lv4;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticOperation {
	public static void main(String[] args) {
		ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
		arithmeticOperation.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"});
	}

	static final int INF=(int)1e9;
	List<Character> opers=new ArrayList<>();
	List<Integer> nums=new ArrayList<>();
	int dp[][][]=new int[2][201][201];


	public int solution(String arr[]) {
		// 연산자 및 숫자 분리
		int n=arr.length/2;
		for(int i=0; i<n+1; i++){
			for(int j=0; j<n+1; j++){
				dp[0][i][j]= -1 * INF;
				dp[1][i][j]= INF;
			}
		}

		for(int i=0; i<arr.length; i++){
			if(i%2==0){
				nums.add(Integer.parseInt(arr[i]));
			}else{
				opers.add(arr[i].charAt(0));
			}
		}

		return solve(0,0,arr.length/2);
	}
	// flag=0 -> 최대, flag =1 -> 최소
	public int solve(int flag, int start,int end){
		if(start==end){
			return dp[flag][start][end]=nums.get(start);
		}

		// 이미 해결했다면
		if(flag ==0 && dp[flag][start][end]!= -1 * INF){
			return dp[flag][start][end];
		}
		if(flag ==1 && dp[flag][start][end]!= INF){
			return dp[flag][start][end];
		}

		int result= (flag == 0) ? -1 * INF : INF;

		dp[flag][start][end]=0; // 방문

		if(flag ==0){
			// 최대를 구하는 경우
			for(int mid = start; mid<end; mid++){
				if(opers.get(mid) == '-'){ // 두 구간 사이 -일 때, (최대 값 - 최소값)
					result = Math.max(result, solve(0,start,mid) - solve(1,mid+1, end));
				}else{ // 두 구간 사이의 연산자 +일때, 최대 + 최대
					result = Math.max(result, solve(0,start,mid) + solve(0,mid+1, end));
				}
			}
		}else{
			// 최소를 구하는 경우
			for(int mid = start; mid<end; mid++){
				if(opers.get(mid) == '-'){ // 두 구간 사이 -일 때, (최대 값 - 최소값)
					result = Math.min(result, solve(1,start,mid) - solve(0,mid+1, end));
				}else{ // 두 구간 사이의 연산자 +일때, 최대 + 최대
					result = Math.min(result, solve(1,start,mid) + solve(1,mid+1, end));
				}
			}
		}

		return dp[flag][start][end]=result;
	}
}

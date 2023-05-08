package BaekJoon.tony.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GaryMandering {
	public static void main(String []args) throws IOException {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(reader.readLine());

		int map[][]=new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n,map));

	}
	static int N;
	static int totalPopulation = 0;
	static int solution(int n,int[][] map){
		int answer=Integer.MAX_VALUE;
		N=n;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				totalPopulation+=map[i][j];
			}
		}

		for(int i=0;i<n; i++){
			for(int j=0; j<n; j++){

				for(int d1=1; d1<n; d1++){
					for(int d2=1; d2<n; d2++){
						if(i+d1+d2>=n) continue;
						if(j-d1<0 || j+d2>=n) continue;

						answer=Math.min(doDivide(i,j,d1,d2,map),answer);
					}
				}
			}
		}

		return answer;
	}

	static int doDivide(int r,int c,int d1,int d2,int[][]map){
		boolean [][] bound=new boolean[N][N];

		for(int i=0;i<=d1; i++){
			bound[r+i][c-i]=true;
			bound[r+d2+i][c+d2-i]=true;
		}

		for(int i=0;i<=d2; i++){
			bound[r+i][c+i]=true;
			bound[r+d1+i][c-d1+i]=true;
		}

		// 1구역
		int[] sum=new int[6];
		for(int i=0; i<r+d1; i++){
			for(int j=0; j<=c; j++){
				if(bound[i][j]) break;
				sum[1]+=map[i][j];
			}
		}

		// 2구역
		for(int i=0; i<=r+d2; i++){
			for(int j=N-1; j>c; j--){
				if(bound[i][j]) break;
				sum[2]+=map[i][j];
			}
		}
		// 3구역
		for(int i=r+d1; i<N; i++){
			for(int j=0; j<c-d1+d2; j++){
				if(bound[i][j]) break;
				sum[3]+=map[i][j];
			}
		}
		// 4구역
		for(int i=r+d2+1; i<N; i++){
			for(int j=N-1; j>=c-d1+d2; j--){
				if(bound[i][j]) break;
				sum[4]+=map[i][j];
			}
		}

		int restSum = Arrays.stream(sum).sum();
		sum[5]=totalPopulation-restSum;

		Arrays.sort(sum);

		return sum[5] - sum[1];
	}
}

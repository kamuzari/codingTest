package programmers.mockquestions.bundle41;

import java.util.Arrays;

public class SharedTaxiFare {
	/**
	 * note : s에서 출발해 a,b 까지의 최소비용 구하기
	 *
	 * resolve :
	 *   1. 최단거리를 구하기 위해 정점이 200개 이므로 3중 loop를 돌려도 TLE가 나지 않는다.
	 *   그러므로 플로이드 와샬 알고리즘을 선택하고
	 *   2. 정점 1-n 까지를 완전탐색한다. s -> 미지수  , 미지수 -> a , 미지수 -> b
	 *     해당 미지수는 출발지점 s와 똑같을 때에는 a 와 b 는 택시를 따로 타고 간다는 의미이다.
	 *     a == 미지수  || b == 미지수의 의미는 같이 가다가 a 또는 b를 내려주고 마지막 a 나 b로 간다. 즉 중간에 떨구는 것이다.
	 */
	private static final int INF=(int)1e9;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = INF;
		int matrix[][]=new int[n+1][n+1];

		for(int i=1; i<n+1; i++){
			Arrays.fill(matrix[i],INF);
			matrix[i][i]=0;
		}

		for(int[] fare : fares){
			int v1=fare[0];
			int v2=fare[1];
			int dist=fare[2];

			matrix[v1][v2]=dist;
			matrix[v2][v1]=dist;
		}

		for(int k=1; k<n+1; k++){
			for(int i=1; i<n+1; i++){
				for(int j=1; j<n+1; j++){
					if(matrix[i][k] ==INF || matrix[k][j]==INF) continue;

					matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
				}
			}
		}

		for(int i=1; i<n+1; i++){
			if(matrix[s][i] != INF && matrix[i][a] != INF && matrix[i][b] != INF) {
				answer=Math.min(answer,matrix[s][i]+matrix[i][a]+matrix[i][b]);
			}
		}

		return answer;
	}
}

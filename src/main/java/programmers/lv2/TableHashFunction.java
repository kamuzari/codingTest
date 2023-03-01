package programmers.lv2;

import java.util.Arrays;

public class TableHashFunction {
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;
		int n=data.length;
		int m=data[0].length;

		Arrays.sort(data,(a,b)-> {

				if(a[col-1]-b[col-1] == 0){
					return b[0] - a[0];
				}

				return a[col-1]-b[col-1];
			}
		);

		int vals[] =new int[n+1];

		for(int i=row_begin; i<=row_end; i++){
			int acculms=0;
			for(int j=0; j<m; j++){
				acculms+=data[i-1][j]%i;
			}
			answer^=acculms;
		}

		return answer;
	}
}

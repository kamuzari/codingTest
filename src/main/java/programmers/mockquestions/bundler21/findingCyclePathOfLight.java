package programmers.mockquestions.bundler21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findingCyclePathOfLight {
	int dy[]={-1,0,1,0};
	int dx[]={0,-1,0,1};
	int n,m;
	boolean v[][][];
	public int[] solution(String[] grid) {
		List<Integer> answers=new ArrayList<>();
		n=grid.length;
		m=grid[0].length();
		v=new boolean[n][m][4];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				for(int k=0; k<4; k++){
					if(v[i][j][k]){
						continue;
					}

					answers.add(getDistance(grid,i,j,k));
				}
			}
		}

		return answers.stream().sorted()
			.mapToInt(val -> val)
			.toArray();
	}

	public int getDistance(String[] grid, int r, int c,int d){
		int cnt=0;

		while(!v[r][c][d]){
			cnt++;
			v[r][c][d]=true;

			if(grid[r].charAt(c) == 'L'){
				d++;
			}else if(grid[r].charAt(c) == 'R'){
				d--;
			}

			d=(d+4)%4;
			r=(r+dy[d]+n)%n;
			c=(c+dx[d]+m)%m;
		}

		return cnt;
	}
}

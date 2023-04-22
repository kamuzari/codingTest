package programmers.lv2;

public class WayToSchool {
	static final int DIVISION_CONSTANT = 1_000_000_007;
	int dy[]={-1,0};
	int dx[]={0,-1};
	int N,M;
	public int solution(int m, int n, int[][] puddles) {
		N=n;
		M=m;
		int dp[][]=new int[n][m];
		dp[0][0]=1;

		for(int [] puddle: puddles){
			int y=puddle[0];
			int x=puddle[1];

			dp[x-1][y-1]=-1;
		}


		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(dp[i][j]==-1){
					dp[i][j]=0;
					continue;
				}

				for(int k=0; k<2; k++){
					int ny=dy[k]+i;
					int nx=dx[k]+j;

					if(isOutOfRange(ny,nx)) continue;
					dp[i][j]+=dp[ny][nx];
				}

				dp[i][j]%=DIVISION_CONSTANT;
			}
		}

		return dp[n-1][m-1];
	}

	boolean isOutOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>=N || nx>=M;
	}
}

package tues_thurs_sat._20210820;

public class PedestrianParadise {
    static final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] fromUp=new int[m+1][n+1];
        int[][] fromRight=new int[m+1][n+1];

        fromUp[1][1]=1;
        fromRight[1][1]=1;

        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                int condition=cityMap[i-1][j-1];
                if(condition==0)
                {
                    fromUp[i][j]+=(fromUp[i-1][j]+fromRight[i][j-1])%MOD;
                    fromRight[i][j]+=(fromUp[i-1][j]+fromRight[i][j-1])%MOD;
                }
                else if(condition==1)
                {
                    continue;
                }
                else if(condition==2)
                {
                    fromUp[i][j]=fromUp[i-1][j];
                    fromRight[i][j]=fromRight[i][j-1];
                }

            }
        }
        return (fromUp[m-1][n]+fromRight[m][n-1])%MOD;
    }
}

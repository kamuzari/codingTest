package tues_thurs_sat._20210820;

public class PedestrianParadise {
    static final int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] rMap=new int[m+1][n+1];
        int[][] uMap=new int[m+1][n+1];

        rMap[1][1]=1;
        uMap[1][1]=1;

        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                int condition=cityMap[i-1][j-1];
                if(condition==0)
                {
                    rMap[i][j]+=(rMap[i-1][j]+uMap[i][j-1])%MOD;
                    uMap[i][j]+=(rMap[i-1][j]+uMap[i][j-1])%MOD;
                }
                else if(condition==1)
                {
                    continue;
                }
                else if(condition==2)
                {
                    rMap[i][j]=rMap[i-1][j];
                    uMap[i][j]=uMap[i][j-1];
                }

            }
        }
        return (rMap[m-1][n]+uMap[m][n-1])%MOD;
    }
}

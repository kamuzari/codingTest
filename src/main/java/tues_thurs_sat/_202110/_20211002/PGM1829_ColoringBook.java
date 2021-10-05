package tues_thurs_sat._202110._20211002;

public class PGM1829_ColoringBook {
    boolean v[][];
    int dy[]={-1,1,0,0};
    int dx[]={0,0,-1,1};
    int M,N;
    int map[][];
    int cnt=0;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int areaCnt=0;
        int areaMaxValue=0;
        map=picture;
        M=m;
        N=n;
        v=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                cnt=0;
                if(picture[i][j]==0){
                    continue;
                }else if(!v[i][j]){
                    areaCnt++;
                    int areaNumber=picture[i][j];
                    dfs(areaNumber,i,j);
                    if(areaMaxValue<cnt){
                        areaMaxValue=cnt;
                    }
                }
            }
        }
        answer[0]=areaCnt;
        answer[1]=areaMaxValue;
        return answer;
    }
    private void dfs(int number,int y,int x){
        cnt++;
        v[y][x]=true;
        for(int i=0; i<4; i++){
            int ny=dy[i]+y;
            int nx=dx[i]+x;
            if(indexOutOf(ny,nx) || v[ny][nx] || map[ny][nx]!=number){
                continue;
            }
            dfs(number,ny,nx);
        }
    }
    private boolean indexOutOf(int y,int x){
        return y<0 || x<0 || y>M-1 || x>N-1;
    }
}

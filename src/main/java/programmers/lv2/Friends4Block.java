package programmers.lv2;

public class Friends4Block {
    int dy[]={1,0,1};
    int dx[]={0,1,1};
    boolean v[][];
    char map[][];
    int N,M;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N=m;
        M=n;
        map=new char[N][M];
        for(int i=0;i<N;i++){
            map[i]=board[i].toCharArray();
        }
        boolean flag;
        do{
            v=new boolean [N][M];
            flag=false;
            for(int i=0; i<N-1; i++){
                for(int j=0; j<M-1; j++){
                    if(isSame(i,j)){
                        flag=true;
                        check(i,j);
                    }
                }
            }
            answer+=erase();
            pulling();

        }while(flag);
        return answer;
    }
    boolean isSame(int y,int x){
        char standard =map[y][x];
        if(standard==' ') return false;
        for(int i=0; i<3; i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(standard!=map[ny][nx]) return false;
        }
        return true;
    }

    public void check(int y,int x){
        v[y][x]=true;
        for(int i=0; i<3; i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            v[ny][nx]=true;
        }
    }

    public int erase(){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(v[i][j]){
                    cnt++;
                    map[i][j]=' ';
                    /*
                    @testCase 5,6,10,11 := 중간에 한번 끊기면 그 위로 전부 끌어당겨야 한다. (줄다리기)와 유사..
                    if(i!=0 && map[i-1][j]!=' '){
                        map[i][j]=map[i-1][j];
                        map[i-1][j]=' ';
                    }*/
                }
            }
        }
        return cnt;
    }
    public void pulling(){
        for (int col = 0; col < M; col++) {
            for (int row = N-1; row >0; row--) {
                int cnt=0;
                while(map[row][col]==' '){
                    if(cnt==row) break;
                    for (int curY = row; curY >0 ; curY--) {
                        map[curY][col]=map[curY-1][col];
                    }
                    cnt++;
                    map[0][col]=' ';
                }
            }
        }
    }
}

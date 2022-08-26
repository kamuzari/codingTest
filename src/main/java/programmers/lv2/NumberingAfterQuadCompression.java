package programmers.lv2;

public class NumberingAfterQuadCompression {
    static final int ZERO=0;
    static final int ONE=1;
    int answer[]=new int[2];
    int map[][];
    public int[] solution(int[][] arr) {
        int n=arr.length;
        map=arr;
        recursion(0,0,n);
        return answer;
    }
    public void recursion(int sy,int sx,int n){
        if(n==1){
            int val=map[sy][sx];
            if(val==ZERO){
                answer[ZERO]++;
            }else if(val==ONE){
                answer[ONE]++;
            }
            return;
        }
        if(allElementsEqual(sy,sx,n)){
            int val=map[sy][sx];
            if(val==ZERO){
                answer[ZERO]++;
            }else if(val==ONE){
                answer[ONE]++;
            }
            return;
        }
        int len=n/2;
        recursion(sy,sx,len);
        recursion(sy,sx+len,len);
        recursion(sy+len,sx,len);
        recursion(sy+len,sx+len,len);
    }
    public boolean allElementsEqual(int sy,int sx,int len){
        int standard=map[sy][sx];
        for(int i=sy; i<sy+len; i++){
            for(int j=sx; j<sx+len; j++){
                if(standard!=map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

package tues_thurs_sat._202109._20210928;

import java.util.Arrays;

public class PGM12592_Nqueen {
    int arr[];
    public static void main(String[] args) {
        PGM12592_Nqueen p = new PGM12592_Nqueen();
        p.solution(4);
    }
    int N;
    int answer;
    public int solution(int n) {
        answer = 0;
        N=n;
        arr=new int[n];
        backTracking(0);
        System.out.println(answer);
        return answer;
    }

    public void backTracking(int cnt){
        if(cnt==N){
            System.out.println(Arrays.toString(arr));
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            if(promising(cnt,i)){
                arr[cnt]=i;
                backTracking(cnt+1);
            }
        }
    }
    public boolean promising(int r,int c){
        for(int i=0; i<r; i++){
            if(arr[i]==c){
                return false;
            }
            if(r-i==Math.abs(c-arr[i])){
                return false;
            }
        }

        return true;
    }
}

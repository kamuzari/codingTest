package Programmers.LV2;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int answer[]=new int[2];
        int sum=brown+yellow;
        for(int i=3; i<=sum; i++){
            if(sum%i==0){
                int row=sum/i; //가로
                int col=sum/row; // 세로
                int a=row-2;
                int b=col-2;
                if(a*b==yellow && row>=col){
                    return new int[]{row,col};
                }
            }
        }
        return null;
    }
}

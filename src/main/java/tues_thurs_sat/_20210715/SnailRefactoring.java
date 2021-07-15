package tues_thurs_sat._20210715;

import java.util.Arrays;

public class SnailRefactoring {
    public static void main(String[] args) {
        System.out.println("solution(6) = " + solution(6));
    }
    public static  int[] solution(int n) {
        int [] answer=new int[(n *(n+1))/2];
        int arr[][]=new int[n][n];

        int y=-1;
        int x=0;
        int number=1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i%3==0)
                    y++;
                else if(i%3==1)
                    x++;
                else if(i%3==2)
                {
                    y--;
                    x--;
                }
                arr[y][x]=number++;
            }
        }
        int idx=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                answer[idx++]=arr[i][j];
            }
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
        return answer;
    }
}

package tues_thurs_sat._20210828;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/30/lessons/12987
public class NumberGame {
    public int solution(int [] A,int [] B)
    {
        int win=0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx=A.length-1;
        for (int i = idx; i >=0; i--) {
            if(B[idx]>A[i])
            {
                win++;
                idx--;
            }
        }
        return win;
    }
}

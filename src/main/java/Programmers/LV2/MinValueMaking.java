package Programmers.LV2;

import java.util.*;

public class MinValueMaking {

    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n=A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int len=n;
        for(int i=0; i<n;i++){
            answer+=(A[i]*B[--len]);
        }

        return answer;
    }
}

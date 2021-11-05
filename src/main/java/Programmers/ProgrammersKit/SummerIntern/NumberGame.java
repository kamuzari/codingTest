package Programmers.ProgrammersKit.SummerIntern;

import java.util.Arrays;

public class NumberGame {
    public static void main(String[] args) {
        int a[]={5, 1, 3, 7};
        int b[]={2, 2, 6, 8};
        System.out.println(solution(a,b));
    }
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx=A.length-1;
        // 어차피 질 거면 제일 안좋은 패.
        for (int i = A.length-1; i >=0 ; i--) {
            if(B[idx]>A[i])
            {
                answer++;
                idx--;
            }
        }
        return answer;
    }
}

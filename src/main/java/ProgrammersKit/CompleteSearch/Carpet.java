package ProgrammersKit.CompleteSearch;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10,2)));
        System.out.println(Arrays.toString(solution(8,1)));
        System.out.println(Arrays.toString(solution(24,24)));
    }
    public static int[] solution(int brown, int yellow) {
        int sum=brown+yellow;

        for(int i=3; i<=sum; i++)
        {
            if(sum%i==0)
            {
                int x=sum/i; // 가로
                int y=sum/x; // 세로

                int a=x-2;
                int b=y-2;
                if(a*b==yellow)
                {
                    if(a>=b)
                        return new int[]{x,y};
                }

            }
        }
        int[] answer = {};
        return answer;
    }
}

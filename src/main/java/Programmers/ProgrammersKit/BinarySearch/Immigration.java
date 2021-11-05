package Programmers.ProgrammersKit.BinarySearch;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {

    }
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long min=1;
        long max= (long) times[times.length - 1] *n;
        long mid=0;
        while (min<=max)
        {
            long sum=0;
            mid=(min+max)/2; // 최소 시간.
            for (int time : times) {
                sum+=mid/time;
                if(sum>=n)
                    break;
            }
            if(sum>=n)
            {
                max=mid-1;
                answer=Math.min(answer,mid);
            }
            else
            {
                min=mid+1;
            }
        }
        return answer;
    }
}

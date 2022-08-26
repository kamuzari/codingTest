package programmers.Kits.BinarySearch;

import java.util.Arrays;

public class steppingStone {
    public static void main(String[] args) {
        System.out.println(solution(25,new int[]{2, 14, 11, 21, 17},2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        long answer = 0;
        Arrays.sort(rocks);
        long min=1;
        long max=distance;
        long mid=0;
        while (min<=max)
        {
            int cnt=0;
            int prev=0;
            mid=(min+max)/2;
            for (int rock : rocks) {
                if(rock-prev<mid)
                    cnt++;
                else
                    prev=rock;
            }
            if(distance-prev<mid)
                cnt++;
            if(cnt<=n)
            {
                answer=Math.max(answer,mid);
                min=mid+1;
            }
            else
            {
                max=mid-1;
            }
        }
        return (int)answer;
    }
}

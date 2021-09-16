package tues_thurs_sat._202109._20210916;

import java.util.Arrays;

public class SteppingStone {
    public static void main(String[] args) {
        SteppingStone s = new SteppingStone();
        System.out.println(s.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
    public  int solution(int distance, int[] rocks, int n) {
        int answer=0;
        int min=0;
        int max=distance;
        Arrays.sort(rocks);
        while (min<=max)
        {
            int mid=(min+max)>>1;
            int removeCnt=0;
            int prev=0;
            for (int rock : rocks) {
                if(rock-prev<mid){
                    removeCnt++;
                }else{
                    prev=rock;
                }
            }
            if(distance-prev<mid){
                removeCnt++;
            }

            if(removeCnt<=n)
            {
                answer=Math.max(answer,mid);
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return answer;
    }
}

package tues_thurs_sat._20210811;

import WeeklyThuseday.maestroReady.Pack;

import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min=1;
        long max= (long) times[times.length - 1] *n;
        while (min<=max)
        {
            long PassengerCount=0;
            long predicateCount=(min+max)/2; // 최소 시간.
            PassengerCount=getCount(predicateCount,times,n);

            if(PassengerCount>=n)
            {
                max=predicateCount-1;
                answer=predicateCount;
            }
            else
            {
                min=predicateCount+1;
            }
        }
        return answer;
    }

    private long getCount(long predicatePassengerNumber, int[] times,int givenPeople) {
        int passCnt=0;
        for (int time : times) {
            passCnt += predicatePassengerNumber / time;
            if(passCnt>=givenPeople)
                return passCnt;
        }
        return passCnt;
    }
}

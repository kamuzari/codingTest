package Programmers.LV3;

import java.util.*;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long minTime=1;
        long maxTime=(long)times[times.length-1]*n;
        while(minTime<=maxTime){
            long givenTime=(minTime+maxTime)>>1;
            long passCount=getPassPeople(givenTime,times,n);
            if(passCount>=n){
                answer=Math.min(answer,givenTime);
                maxTime=givenTime-1;
            }else{
                minTime=givenTime+1;
            }
        }
        return answer;
    }
    private long getPassPeople(long givenTime,int[] times, int totalPeople){
        long passCount=0;
        for(int time : times){
            passCount+=(givenTime/time);
            if(totalPeople<=passCount){
                return passCount;
            }
        }
        return passCount;
    }
}

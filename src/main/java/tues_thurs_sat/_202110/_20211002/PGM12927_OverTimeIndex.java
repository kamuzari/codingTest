package tues_thurs_sat._202110._20211002;

import java.util.PriorityQueue;

public class PGM12927_OverTimeIndex {
    public static void main(String[] args) {
        PGM12927_OverTimeIndex p = new PGM12927_OverTimeIndex();
        p.solution(4,new int[]{4,3,3});
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2)-> o2-o1);
        for(int work : works){
            pq.offer(work);
        }
        while(n>0){
            int workload=pq.poll();
            workload--;
            n--;
            if(workload!=0){
                pq.offer(workload);
            }
            if(pq.isEmpty()){
                break;
            }
        }
         while(!pq.isEmpty()){
             int cur=pq.poll();
             answer+=(cur*cur);
         }
        return answer;
    }
}

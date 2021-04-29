package tues_thurs_sat._20210429;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class OvertimeIndex {
    public static void main(String[] args) {
        System.out.println(solution(4,new int[]{4,3,3}));
    }
    public static  long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        return b-a;
                    }
                }
        );
        for(int val:works)
        {
            pq.offer(val);
        }

        while (n-->0)
        {
            if(pq.isEmpty())
                break;
            else{
                Integer val = pq.poll();
                if(val>0)
                {
                    val--;
                    if(val!=0)
                    {
                        pq.offer(val);
                    }
                }
            }
        }
        while (!pq.isEmpty())
        {
            answer+=Math.pow(pq.poll(),2);
        }
        return answer;
    }
}

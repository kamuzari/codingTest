package programmers.lv2;
import java.util.*;
public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int sco[]=scoville;
        int k=K;

        for(int i=0; i<sco.length;i++){
            pq.offer(sco[i]);
        }

        while(pq.peek()<k && pq.size()>1){
            if(pq.peek()<k && pq.size()>1){
                int a=pq.poll();
                int b=pq.poll();
                pq.offer(a+(b*2));
                answer++;
            }
        }
        if(pq.peek()>=k){
            return answer;
        }
        return -1;
    }

}

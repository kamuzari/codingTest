package programmers.Kits.Heap;

import java.util.PriorityQueue;

public class moreSpicy {
    public static void main(String[] args) {
        int[] sco={1, 2, 3, 9, 10, 12};
        int k=7;
        System.out.println(solution(sco,k));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++)
        {
            pq.offer(scoville[i]);
        }
        while(!pq.isEmpty()&&pq.peek()<K)
        {
            int cur=pq.poll();
            int cur2;
            if(cur<K)
            {
                if(!pq.isEmpty())
                {
                    cur2=pq.poll();
                    int sum=cur+(cur2*2);
                    pq.offer(sum);
                    answer++;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                break;
            }
        }

        return answer;
    }
}
